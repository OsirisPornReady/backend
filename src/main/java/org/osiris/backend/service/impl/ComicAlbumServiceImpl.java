package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.ComicAlbum;
import org.osiris.backend.mapper.ComicAlbumMapper;
import org.osiris.backend.dto.ComicAlbumDTO;
import org.osiris.backend.service.ComicAlbumService;
import org.osiris.backend.utils.ArrayConvertUtils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ComicAlbumServiceImpl extends ServiceImpl<ComicAlbumMapper, ComicAlbum> implements ComicAlbumService {

    @Override
    public ComicAlbum dto2entity(ComicAlbumDTO ComicAlbumDTO) {
        ComicAlbum ComicAlbum = new ComicAlbum();
        BeanUtils.copyProperties(ComicAlbumDTO, ComicAlbum, "albumComicIdList");
        String albumComicIdList = ArrayConvertUtils.list2string(ComicAlbumDTO.getAlbumComicIdList());
        ComicAlbum.setAlbumComicIdList(albumComicIdList);
        return ComicAlbum;
    }

    @Override
    public ComicAlbumDTO entity2dto(ComicAlbum ComicAlbum) {
        ComicAlbumDTO ComicAlbumDTO = new ComicAlbumDTO();
        BeanUtils.copyProperties(ComicAlbum, ComicAlbumDTO, "albumComicIdList");
        List<Integer> albumComicIdList = ArrayConvertUtils.string2list(ComicAlbum.getAlbumComicIdList());
        ComicAlbumDTO.setAlbumComicIdList(albumComicIdList);
        return ComicAlbumDTO;
    }

    @Override
    public STResDTO getByPage(Integer pi, Integer ps) {
        Page<ComicAlbum> page = new Page<>(pi, ps);
        QueryWrapper<ComicAlbum> queryWrapper = new QueryWrapper<>();
        IPage<ComicAlbum> ipage = this.page(page, queryWrapper);
        ipage.convert(this::entity2dto);
        STResDTO stRes = new STResDTO();
        stRes.setList(ipage.getRecords());
        stRes.setTotal(ipage.getTotal());
        return stRes;
    }

    @Override
    public void addComicAlbum(ComicAlbumDTO ComicAlbumDTO) {
        this.save(this.dto2entity(ComicAlbumDTO));
    }

    @Override
    public void updateComicAlbum(ComicAlbumDTO ComicAlbumDTO, Integer id) {
        UpdateWrapper<ComicAlbum> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        this.update(this.dto2entity(ComicAlbumDTO), updateWrapper);
    }

    @Override
    public ComicAlbumDTO getDTOById(Integer id) {
        return entity2dto(this.getById(id));
    }

//    @Override
//    public void collectVideo(Integer id, VideoCollectDTO videoCollectDTO) {
//        List<Integer> removeFromList = videoCollectDTO.getRemoveFromList();
//        List<Integer> addToList = videoCollectDTO.getAddToList();
//
//        removeFromList.forEach(eachId -> {
//            ComicAlbum album = this.getById(eachId);
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
//            ComicAlbum album = this.getById(eachId);
//            List<Integer> albumVideoList = ArrayConvertUtils.string2list(album.getAlbumVideoList());
//            if (albumVideoList == null) {
//                albumVideoList = new ArrayList<Integer>();
//            }
//            albumVideoList.add(id);
//            album.setAlbumVideoList(ArrayConvertUtils.list2string(albumVideoList));
//            this.updateById(album);
//        });
//    }
//
//    @Override
//    public List<ComicAlbum> getAlbumCollectedVideo(Integer id) {
//        QueryWrapper<ComicAlbum> queryWrapper = new QueryWrapper<>();
//        String likePattern = String.format(",%s,", id.toString());
//        String likeLeftPattern = String.format(",%s", id.toString()); //这里的左右是针对sql来说的,不要从字面上理解
//        String likeRightPattern = String.format("%s,", id.toString());
//        // 主动调用or表示紧接着下一个方法不是用and连接!(不调用or则默认为使用and连接)
//        queryWrapper.like("albumVideoIdList", likePattern).or()
//                    .likeLeft("albumVideoIdList", likeLeftPattern).or()
//                    .likeRight("albumVideoIdList", likeRightPattern);
//        return this.list(queryWrapper);
//    }

}
