package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.github.houbb.opencc4j.util.ZhConverterUtil;

import org.osiris.backend.entity.VideoOnClient;
import org.osiris.backend.service.VideoOnClientService;
import org.osiris.backend.utils.StringManipUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.entity.Video;
import org.osiris.backend.mapper.VideoMapper;
import org.osiris.backend.service.VideoService;
import org.osiris.backend.dto.VideoDTO;
import org.osiris.backend.utils.ArrayConvertUtils;
import org.osiris.backend.utils.DateConvertUtils;



@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    private final VideoOnClientService videoOnClientService;

    public VideoServiceImpl(VideoOnClientService videoOnClientService) {
        this.videoOnClientService = videoOnClientService;
    }

    @Override
    public Video dto2entity(VideoDTO videoDTO) {
        Video video = new Video();

        BeanUtils.copyProperties(videoDTO, video, "publishTime", "series", "tags", "stars", "tagsRaw", "starsRaw", "addTime", "updateTime", "videoSrc", "previewImageSrcList", "localPreviewImageSrcList", "previewImageBase64List");

        String tags = ArrayConvertUtils.list2string(videoDTO.getTags());
        String stars = ArrayConvertUtils.list2string(videoDTO.getStars());
        String tagsRaw = ArrayConvertUtils.liststring2string(videoDTO.getTagsRaw());
        String starsRaw = ArrayConvertUtils.liststring2string(videoDTO.getStarsRaw());
        String series = ArrayConvertUtils.liststring2string(videoDTO.getSeries());
        String videoSrc = ArrayConvertUtils.liststring2string(videoDTO.getVideoSrc());
        String previewImageSrcList = ArrayConvertUtils.liststring2string(videoDTO.getPreviewImageSrcList());
        String localPreviewImageSrcList = ArrayConvertUtils.liststring2string(videoDTO.getLocalPreviewImageSrcList());
        String previewImageBase64List = ArrayConvertUtils.liststring2string(videoDTO.getPreviewImageBase64List());
        String publishTime = DateConvertUtils.date2string(videoDTO.getPublishTime());
        String addTime = DateConvertUtils.date2string(videoDTO.getAddTime());
        String updateTime = DateConvertUtils.date2string(videoDTO.getUpdateTime());

        video.setTags(tags);
        video.setStars(stars);
        video.setTagsRaw(tagsRaw);
        video.setStarsRaw(starsRaw);
        video.setSeries(series);
        video.setVideoSrc(videoSrc);
        video.setPreviewImageSrcList(previewImageSrcList);
        video.setLocalPreviewImageSrcList(localPreviewImageSrcList);
        video.setPreviewImageBase64List(previewImageBase64List);
        video.setPublishTime(publishTime);
        video.setAddTime(addTime);
        video.setUpdateTime(updateTime);
        return video;
    }

    @Override
    public VideoDTO entity2dto(Video video) {
        VideoDTO videoDTO = new VideoDTO();
        BeanUtils.copyProperties(video, videoDTO, "publishTime", "series", "tags", "stars", "tagsRaw", "starsRaw", "addTime", "updateTime", "videoSrc", "previewImageSrcList", "localPreviewImageSrcList", "previewImageBase64List");
        List<Integer> tags = ArrayConvertUtils.string2list(video.getTags());
        List<Integer> stars = ArrayConvertUtils.string2list(video.getStars());
        List<String> tagsRaw = ArrayConvertUtils.string2stringlist(video.getTagsRaw());
        List<String> starsRaw = ArrayConvertUtils.string2stringlist(video.getStarsRaw());
        List<String> series = ArrayConvertUtils.string2stringlist(video.getSeries());
        List<String> videoSrc = ArrayConvertUtils.string2stringlist(video.getVideoSrc());
        List<String> previewImageSrcList = ArrayConvertUtils.string2stringlist(video.getPreviewImageSrcList());
        List<String> localPreviewImageSrcList = ArrayConvertUtils.string2stringlist(video.getLocalPreviewImageSrcList());
        List<String> previewImageBase64List = ArrayConvertUtils.string2stringlist(video.getPreviewImageBase64List());
        Date publishTime = DateConvertUtils.string2date(video.getPublishTime());
        Date addTime = DateConvertUtils.string2date(video.getAddTime());
        Date updateTime = DateConvertUtils.string2date(video.getUpdateTime());
        videoDTO.setTags(tags);
        videoDTO.setStars(stars);
        videoDTO.setTagsRaw(tagsRaw);
        videoDTO.setStarsRaw(starsRaw);
        videoDTO.setSeries(series);
        videoDTO.setVideoSrc(videoSrc);
        videoDTO.setPreviewImageSrcList(previewImageSrcList);
        videoDTO.setLocalPreviewImageSrcList(localPreviewImageSrcList);
        videoDTO.setPreviewImageBase64List(previewImageBase64List);
        videoDTO.setPublishTime(publishTime);
        videoDTO.setAddTime(addTime);
        videoDTO.setUpdateTime(updateTime);
        return videoDTO;
    }

    @Override
    public STResDTO getByPage(Integer pi, Integer ps,
                              List<String> sort, String defaultSort,
                              String keyword,
                              String title,
                              String serialNumber,
                              String starsRaw,
                              String tagsRaw,
                              String publishTimeStart,
                              String publishTimeEnd,
                              String addTimeStart,
                              String addTimeEnd,
                              List<String> compoundKeyword,
                              Integer onClient) {
        Page<Video> page = new Page<>(pi, ps);
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();

        // 排序相关
        if (Objects.equals(defaultSort, "null")){
            defaultSort = null;
        }
        if (sort == null && defaultSort == null) {
            queryWrapper.orderByDesc("addTime");
        } else {
            if (sort != null) {
                sort.forEach(s -> {
                    List<String> params = StringManipUtils.splitSort(s);
                    if (params.size() == 2) {
                        if (Objects.equals(params.get(1), "descend")) {
                            queryWrapper.orderByDesc(params.get(0));
                        } else if (Objects.equals(params.get(1), "ascend")) {
                            queryWrapper.orderByAsc(params.get(0));
                        }
                    }
                });
            }
            if (defaultSort != null) {
                List<String> params = StringManipUtils.splitSort(defaultSort);
                if (params.size() == 2) {
                    if (Objects.equals(params.get(1), "descend")) {
                        queryWrapper.orderByDesc(params.get(0));
                    } else if (Objects.equals(params.get(1), "ascend")) {
                        queryWrapper.orderByAsc(params.get(0));
                    }
                }
            }
        }

        // 搜索相关
        if (keyword != null) {
            String traditionalCHNKeyword = ZhConverterUtil.toTraditional(keyword);
            // 默认使用and, 所以直接使用nested和其他配合也行
            queryWrapper.and(wrapper -> wrapper.like("title", keyword).or()
                                               .like("title", traditionalCHNKeyword).or()
                                               .like("serialNumber", keyword).or()
                                               .like("starsRaw", keyword).or()
                                               .like("starsRaw", traditionalCHNKeyword).or()
                                               .like("tagsRaw", keyword).or()
                                               .like("tagsRaw", traditionalCHNKeyword).or()
                                               .like("publishTime", keyword));
        } else if (compoundKeyword != null) {
            for (String ck : compoundKeyword) {
                String traditionalCHNCK = ZhConverterUtil.toTraditional(ck);
                queryWrapper.and(wrapper -> wrapper.like("title", ck).or()
                                                   .like("title", traditionalCHNCK).or()
                                                   .like("serialNumber", ck).or()
                                                   .like("starsRaw", ck).or()
                                                   .like("starsRaw", traditionalCHNCK).or()
                                                   .like("tagsRaw", ck).or()
                                                   .like("tagsRaw", traditionalCHNCK).or()
                                                   .like("publishTime", ck));
            }
        } else { //并不需要精准匹配,也就不需要likeleft和likeright
            if (title != null) {
                String traditionalCHNTitle = ZhConverterUtil.toTraditional(title);
                queryWrapper.and(wrapper -> wrapper.like("title", title).or()
                                                   .like("title", traditionalCHNTitle));
            }
            if (serialNumber != null) {
                queryWrapper.like("serialNumber", serialNumber);
            }
            if (starsRaw != null) {
                String traditionalCHNStarsRaw = ZhConverterUtil.toTraditional(starsRaw);
                queryWrapper.and(wrapper -> wrapper.like("starsRaw", starsRaw).or()
                                                   .like("starsRaw", traditionalCHNStarsRaw));
            }
            if (tagsRaw != null) {
                String traditionalCHNTagsRaw = ZhConverterUtil.toTraditional(tagsRaw);
                queryWrapper.and(wrapper -> wrapper.like("tagsRaw", tagsRaw).or()
                                                   .like("tagsRaw", traditionalCHNTagsRaw));
            }
            if (publishTimeStart != null && publishTimeEnd != null) { //前端选择器就已经判断先后关系了,此处不必判断,只需判断相等
                if (Objects.equals(publishTimeStart, publishTimeEnd)) {
                    queryWrapper.and(wrapper -> wrapper.like("publishTime", publishTimeStart));
                } else {
                    // 主动调用or表示紧接着下一个方法不是用and连接!(不调用or则默认为使用and连接)
                    // 也可以写成链式写法
//                    queryWrapper.ge("publishTime", publishTimeStart);
//                    queryWrapper.le("publishTime", publishTimeEnd);
                    queryWrapper.and(wrapper -> wrapper.ge("publishTime", publishTimeStart)
                                                       .le("publishTime", publishTimeEnd));
                }
            }
            if (addTimeStart != null && addTimeEnd != null) { //前端选择器就已经判断先后关系了,此处不必判断,只需判断相等
                if (Objects.equals(addTimeStart, addTimeEnd)) {
                    queryWrapper.like("addTime", addTimeStart);
                } else {
                    // 主动调用or表示紧接着下一个方法不是用and连接!(不调用or则默认为使用and连接)
                    // 也可以写成链式写法
//                    queryWrapper.ge("addTime", addTimeStart);
//                    queryWrapper.le("addTime", addTimeEnd);
                    queryWrapper.and(wrapper -> wrapper.ge("addTime", addTimeStart)
                                                       .le("addTime", addTimeEnd));
                }
            }
        }

        // 过滤相关
        if (onClient == 1) {
            QueryWrapper<VideoOnClient> vocQueryWrapper = new QueryWrapper<>();
            vocQueryWrapper.select("id", "videoId");
            List<VideoOnClient> voclist = videoOnClientService.list(vocQueryWrapper);
            List<Integer> idListOnClient = voclist.stream().map(VideoOnClient::getVideoId).distinct().toList();
            if (idListOnClient.size() > 0) {
                queryWrapper.and(wrapper -> wrapper.in("id", idListOnClient));
            }
        }

        IPage<Video> ipage = this.page(page, queryWrapper);
        ipage.convert(this::entity2dto); //如果逻辑复杂一点还可以写成lambda表达式
        STResDTO stRes = new STResDTO();
        stRes.setList(ipage.getRecords());
        stRes.setTotal(ipage.getTotal());
        return stRes;
    }

    @Override
    public Integer addVideo(VideoDTO videoDTO) {
        Video video = this.dto2entity(videoDTO);
        boolean result = this.save(video);
        if (result) {
            return video.getId();
        } else {
            return -1;
        }
    }

    @Override
    public Integer updateVideo(VideoDTO videoDTO, Integer id) {
        UpdateWrapper<Video> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        boolean result = this.update(this.dto2entity(videoDTO), updateWrapper);
        if (result) {
            return id;
        } else {
            return -1;
        }
    }

    @Override
    public VideoDTO getDTOById(Integer id) {
        return entity2dto(this.getById(id));
    }

    @Override
    public Boolean isSerialNumberExist(String serialNumber) {
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Video::getSerialNumber, serialNumber);
        List<Video> list = this.list(queryWrapper);
        return list.size() > 0;
    }

    @Override
    public Boolean isTitleExist(String title) {
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(Video::getTitle, title);
        queryWrapper.lambda().likeLeft(Video::getTitle, title);
        queryWrapper.lambda().likeRight(Video::getTitle, title);
        List<Video> list = this.list(queryWrapper);
        return list.size() > 0;
    }

    @Override
    public void switchVideoSubscription(Integer id) {
        Video video = this.getById(id);
        if (video != null) {
            Boolean onSubscription = video.getOnSubscription();
            Boolean newValue;
            if (onSubscription == null || onSubscription == false) {
                newValue = false;
            } else {
                newValue = true;
            }
            UpdateWrapper<Video> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", id)
                    .set("onSubscription", newValue);
            this.update(updateWrapper);
        }
    }
}
