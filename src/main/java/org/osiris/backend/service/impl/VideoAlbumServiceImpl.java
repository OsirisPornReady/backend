package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.VideoAlbumDTO;
import org.osiris.backend.dto.VideoCollectDTO;
import org.osiris.backend.entity.VideoAlbum;
import org.osiris.backend.mapper.VideoAlbumMapper;
import org.osiris.backend.service.VideoAlbumService;
import org.osiris.backend.utils.ArrayConvertUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class VideoAlbumServiceImpl extends ServiceImpl<VideoAlbumMapper, VideoAlbum> implements VideoAlbumService {

    @Override
    public VideoAlbum dto2entity(VideoAlbumDTO videoAlbumDTO) {
        VideoAlbum videoAlbum = new VideoAlbum();
        BeanUtils.copyProperties(videoAlbumDTO, videoAlbum, "albumVideoIdList");
        String albumVideoIdList = ArrayConvertUtils.list2string(videoAlbumDTO.getAlbumVideoIdList());
        videoAlbum.setAlbumVideoIdList(albumVideoIdList);
        return videoAlbum;
    }

    @Override
    public VideoAlbumDTO entity2dto(VideoAlbum videoAlbum) {
        VideoAlbumDTO videoAlbumDTO = new VideoAlbumDTO();
        BeanUtils.copyProperties(videoAlbum, videoAlbumDTO, "albumVideoIdList");
        List<Integer> albumVideoIdList = ArrayConvertUtils.string2list(videoAlbum.getAlbumVideoIdList());
        videoAlbumDTO.setAlbumVideoIdList(albumVideoIdList);
        return videoAlbumDTO;
    }

    @Override
    public STResDTO getByPage(Integer pi, Integer ps) {
        Page<VideoAlbum> page = new Page<>(pi, ps);
        QueryWrapper<VideoAlbum> queryWrapper = new QueryWrapper<>();
        IPage<VideoAlbum> ipage = this.page(page, queryWrapper);
        ipage.convert(this::entity2dto);
        STResDTO stRes = new STResDTO();
        stRes.setList(ipage.getRecords());
        stRes.setTotal(ipage.getTotal());
        return stRes;
    }

    @Override
    public void addVideoAlbum(VideoAlbumDTO videoAlbumDTO) {
        this.save(this.dto2entity(videoAlbumDTO));
    }

    @Override
    public void updateVideoAlbum(VideoAlbumDTO videoAlbumDTO, Integer id) {
        UpdateWrapper<VideoAlbum> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        this.update(this.dto2entity(videoAlbumDTO), updateWrapper);
    }

    @Override
    public VideoAlbumDTO getDTOById(Integer id) {
        return entity2dto(this.getById(id));
    }

    @Override
    public void collectVideo(Integer id, VideoCollectDTO videoCollectDTO) {
        List<Integer> removeFromList = videoCollectDTO.getRemoveFromList();
        List<Integer> addToList = videoCollectDTO.getAddToList();

//        removeFromList.forEach(eachId -> {
//            VideoAlbum album = this.getById(eachId);
//            List<Integer> albumVideoList = ArrayConvertUtils.string2list(album.getAlbumVideoList());
//            if (albumVideoList == null) {
//                albumVideoList = new ArrayList<Integer>();
//            }
//            albumVideoList.remove((Integer) id); //显示指定方法,以免跟参数为index重载方法弄混
//            album.setAlbumVideoIdList(ArrayConvertUtils.list2string(albumVideoList));
//            this.updateById(album);
//        });
//
//        addToList.forEach(eachId -> {
//            VideoAlbum album = this.getById(eachId);
//            List<Integer> albumVideoList = ArrayConvertUtils.string2list(album.getAlbumVideoList());
//            if (albumVideoList == null) {
//                albumVideoList = new ArrayList<Integer>();
//            }
//            albumVideoList.add(id);
//            album.setAlbumVideoList(ArrayConvertUtils.list2string(albumVideoList));
//            this.updateById(album);
//        });
    }

    @Override
    public List<VideoAlbum> getAlbumCollectedVideo(Integer id) {
        QueryWrapper<VideoAlbum> queryWrapper = new QueryWrapper<>();
        String likePattern = String.format(",%s,", id.toString());
        String likeLeftPattern = String.format(",%s", id.toString()); //这里的左右是针对sql来说的,不要从字面上理解
        String likeRightPattern = String.format("%s,", id.toString());
        // 主动调用or表示紧接着下一个方法不是用and连接!(不调用or则默认为使用and连接)
        queryWrapper.like("albumVideoIdList", likePattern).or()
                    .likeLeft("albumVideoIdList", likeLeftPattern).or()
                    .likeRight("albumVideoIdList", likeRightPattern);
        return this.list(queryWrapper);
    }

}
