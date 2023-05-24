package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.osiris.backend.dto.STResDTO;
import org.osiris.backend.dto.ComicDTO;
import org.osiris.backend.entity.Comic;
import org.osiris.backend.mapper.ComicMapper;
import org.osiris.backend.service.ComicService;
import org.osiris.backend.utils.ArrayConvertUtils;
import org.osiris.backend.utils.DateConvertUtils;
import org.osiris.backend.utils.StringManipUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;


@Service
public class ComicServiceImpl extends ServiceImpl<ComicMapper, Comic> implements ComicService {

    @Override
    public Comic dto2entity(ComicDTO comicDTO) {
        Comic comic = new Comic();
        BeanUtils.copyProperties(comicDTO, comic, "language", "parody", "character", "group", "artist", "male", "female", "mixed", "other", "postedTime", "previewImageSrcList", "localPreviewImageSrcList", "addTime", "updateTime", "comicPicLinkList", "comicFailOrderList", "localComicPicSrcList");

        String languageTags = ArrayConvertUtils.liststring2string(comicDTO.getLanguageTags());
        String parodyTags = ArrayConvertUtils.liststring2string(comicDTO.getParodyTags());
        String characterTags = ArrayConvertUtils.liststring2string(comicDTO.getCharacterTags());
        String groupTags = ArrayConvertUtils.liststring2string(comicDTO.getGroupTags());
        String artistTags = ArrayConvertUtils.liststring2string(comicDTO.getArtistTags());
        String maleTags = ArrayConvertUtils.liststring2string(comicDTO.getMaleTags());
        String femaleTags = ArrayConvertUtils.liststring2string(comicDTO.getFemaleTags());
        String mixedTags = ArrayConvertUtils.liststring2string(comicDTO.getMixedTags());
        String otherTags = ArrayConvertUtils.liststring2string(comicDTO.getOtherTags());

        String series = ArrayConvertUtils.liststring2string(comicDTO.getSeries());
        String comicSrc = ArrayConvertUtils.liststring2string(comicDTO.getComicSrc());
        String previewImageSrcList = ArrayConvertUtils.liststring2string(comicDTO.getPreviewImageSrcList());
        String localPreviewImageSrcList = ArrayConvertUtils.liststring2string(comicDTO.getLocalPreviewImageSrcList());
        String comicPicLinkList = ArrayConvertUtils.liststring2string(comicDTO.getComicPicLinkList());
        String comicFailOrderList = ArrayConvertUtils.liststring2string(comicDTO.getComicFailOrderList());
        String localComicPicSrcList = ArrayConvertUtils.liststring2string(comicDTO.getLocalComicPicSrcList());
        String postedTime = DateConvertUtils.date2string(comicDTO.getPostedTime());
        String addTime = DateConvertUtils.date2string(comicDTO.getAddTime());
        String updateTime = DateConvertUtils.date2string(comicDTO.getUpdateTime());

        comic.setLanguageTags(languageTags);
        comic.setParodyTags(parodyTags);
        comic.setCharacterTags(characterTags);
        comic.setGroupTags(groupTags);
        comic.setArtistTags(artistTags);
        comic.setMaleTags(maleTags);
        comic.setFemaleTags(femaleTags);
        comic.setMixedTags(mixedTags);
        comic.setOtherTags(otherTags);
        comic.setSeries(series);
        comic.setComicSrc(comicSrc);
        comic.setPreviewImageSrcList(previewImageSrcList);
        comic.setLocalPreviewImageSrcList(localPreviewImageSrcList);
        comic.setComicPicLinkList(comicPicLinkList);
        comic.setComicFailOrderList(comicFailOrderList);
        comic.setLocalComicPicSrcList(localComicPicSrcList);
        comic.setPostedTime(postedTime);
        comic.setAddTime(addTime);
        comic.setUpdateTime(updateTime);

        return comic;
    }

    @Override
    public ComicDTO entity2dto(Comic comic) {
        ComicDTO comicDTO = new ComicDTO();
        BeanUtils.copyProperties(comic, comicDTO, "language", "parody", "character", "group", "artist", "male", "female", "mixed", "other", "postedTime", "previewImageSrcList", "localPreviewImageSrcList", "addTime", "updateTime", "comicPicLinkList", "comicFailOrderList", "localComicPicSrcList");

        List<String> languageTags = ArrayConvertUtils.string2stringlist(comic.getLanguageTags());
        List<String> parodyTags = ArrayConvertUtils.string2stringlist(comic.getParodyTags());
        List<String> characterTags = ArrayConvertUtils.string2stringlist(comic.getCharacterTags());
        List<String> groupTags = ArrayConvertUtils.string2stringlist(comic.getGroupTags());
        List<String> artistTags = ArrayConvertUtils.string2stringlist(comic.getArtistTags());
        List<String> maleTags = ArrayConvertUtils.string2stringlist(comic.getMaleTags());
        List<String> femaleTags = ArrayConvertUtils.string2stringlist(comic.getFemaleTags());
        List<String> mixedTags = ArrayConvertUtils.string2stringlist(comic.getMixedTags());
        List<String> otherTags = ArrayConvertUtils.string2stringlist(comic.getOtherTags());
        List<String> series = ArrayConvertUtils.string2stringlist(comic.getSeries());
        List<String> comicSrc = ArrayConvertUtils.string2stringlist(comic.getComicSrc());
        List<String> previewImageSrcList = ArrayConvertUtils.string2stringlist(comic.getPreviewImageSrcList());
        List<String> localPreviewImageSrcList = ArrayConvertUtils.string2stringlist(comic.getLocalPreviewImageSrcList());
        List<String> comicPicLinkList = ArrayConvertUtils.string2stringlist(comic.getComicPicLinkList());
        List<String> comicFailOrderList = ArrayConvertUtils.string2stringlist(comic.getComicFailOrderList());
        List<String> localComicPicSrcList = ArrayConvertUtils.string2stringlist(comic.getLocalComicPicSrcList());
        Date postedTime = DateConvertUtils.string2date(comic.getPostedTime());
        Date addTime = DateConvertUtils.string2date(comic.getAddTime());
        Date updateTime = DateConvertUtils.string2date(comic.getUpdateTime());

        comicDTO.setLanguageTags(languageTags);
        comicDTO.setParodyTags(parodyTags);
        comicDTO.setCharacterTags(characterTags);
        comicDTO.setGroupTags(groupTags);
        comicDTO.setArtistTags(artistTags);
        comicDTO.setMaleTags(maleTags);
        comicDTO.setFemaleTags(femaleTags);
        comicDTO.setMixedTags(mixedTags);
        comicDTO.setOtherTags(otherTags);
        comicDTO.setSeries(series);
        comicDTO.setComicSrc(comicSrc);
        comicDTO.setPreviewImageSrcList(previewImageSrcList);
        comicDTO.setLocalPreviewImageSrcList(localPreviewImageSrcList);
        comicDTO.setComicPicLinkList(comicPicLinkList);
        comicDTO.setComicFailOrderList(comicFailOrderList);
        comicDTO.setLocalComicPicSrcList(localComicPicSrcList);
        comicDTO.setPostedTime(postedTime);
        comicDTO.setAddTime(addTime);
        comicDTO.setUpdateTime(updateTime);

        return comicDTO;
    }

    @Override
    public STResDTO getByPage(Integer pi, Integer ps, List<String> sort, String defaultSort, String keyword, String title, String titleJap, String languageTags, String parodyTags, String characterTags, String groupTags, String artistTags, String maleTags, String femaleTags, String mixedTags, String otherTags, String postedTimeStart, String postedTimeEnd, String addTimeStart, String addTimeEnd) {
        Page<Comic> page = new Page<>(pi, ps);
        QueryWrapper<Comic> queryWrapper = new QueryWrapper<>();
        if (Objects.equals(defaultSort, "null")){
            defaultSort = null;
        }
        if (sort == null && defaultSort == null) {
            queryWrapper.orderByDesc("updateTime");
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
        if (keyword != null) {
            queryWrapper.like("title", keyword).or()
                        .like("titleJap", keyword).or()
                        .like("languageTags", keyword).or()
                        .like("parodyTags", keyword).or()
                        .like("characterTags", keyword).or()
                        .like("groupTags", keyword).or()
                        .like("artistTags", keyword).or()
                        .like("maleTags", keyword).or()
                        .like("femaleTags", keyword).or()
                        .like("mixedTags", keyword).or()
                        .like("otherTags", keyword).or()
                        .like("postedTime", keyword);
        } else { //并不需要精准匹配,也就不需要likeleft和likeright
            if (title != null) {
                queryWrapper.like("title", title);
            }
            if (titleJap != null) {
                queryWrapper.like("titleEnd", titleJap);
            }
            if (languageTags != null) {
                queryWrapper.like("languageTags", languageTags);
            }
            if (parodyTags != null) {
                queryWrapper.like("parodyTags", parodyTags);
            }
            if (characterTags != null) {
                queryWrapper.like("characterTags", characterTags);
            }
            if (groupTags != null) {
                queryWrapper.like("groupTags", groupTags);
            }
            if (artistTags != null) {
                queryWrapper.like("artistTags", artistTags);
            }
            if (maleTags != null) {
                queryWrapper.like("maleTags", maleTags);
            }
            if (femaleTags != null) {
                queryWrapper.like("femaleTags", femaleTags);
            }
            if (mixedTags != null) {
                queryWrapper.like("mixedTags", mixedTags);
            }
            if (otherTags != null) {
                queryWrapper.like("otherTags", otherTags);
            }
            if (postedTimeStart != null && postedTimeEnd != null) { //前端选择器就已经判断先后关系了,此处不必判断,只需判断相等
                if (Objects.equals(postedTimeStart, postedTimeEnd)) {
                    queryWrapper.like("postedTime", postedTimeStart);
                } else {
                    // 主动调用or表示紧接着下一个方法不是用and连接!(不调用or则默认为使用and连接)
                    // 也可以写成链式写法
                    queryWrapper.ge("postedTime", postedTimeStart);
                    queryWrapper.le("postedTime", postedTimeEnd);
                }
            }
            if (addTimeStart != null && addTimeEnd != null) { //前端选择器就已经判断先后关系了,此处不必判断,只需判断相等
                if (Objects.equals(addTimeStart, addTimeEnd)) {
                    queryWrapper.like("addTime", addTimeStart);
                } else {
                    // 主动调用or表示紧接着下一个方法不是用and连接!(不调用or则默认为使用and连接)
                    // 也可以写成链式写法
                    queryWrapper.ge("addTime", addTimeStart);
                    queryWrapper.le("addTime", addTimeEnd);
                }
            }
        }
        IPage<Comic> ipage = this.page(page, queryWrapper);
        ipage.convert(this::entity2dto); //如果逻辑复杂一点还可以写成lambda表达式
        STResDTO stRes = new STResDTO();
        stRes.setList(ipage.getRecords());
        stRes.setTotal(ipage.getTotal());
        return stRes;
    }

    @Override
    public void addComic(ComicDTO comicDTO) {
        this.save(this.dto2entity(comicDTO));
    }

    @Override
    public void updateComic(ComicDTO comicDTO, Integer id) {
        UpdateWrapper<Comic> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        this.update(this.dto2entity(comicDTO), updateWrapper);
    }

    @Override
    public ComicDTO getDTOById(Integer id) {
        return entity2dto(this.getById(id));
    }

//    @Override
//    public Boolean isSerialNumberExist(String serialNumber) {
//        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(Video::getSerialNumber, serialNumber);
//        List<Video> list = this.list(queryWrapper);
//        return list.size() > 0;
//    }

    @Override
    public Boolean isTitleExist(String title) {
        QueryWrapper<Comic> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(Comic::getTitle, title);
        queryWrapper.lambda().likeLeft(Comic::getTitle, title);
        queryWrapper.lambda().likeRight(Comic::getTitle, title);
        List<Comic> list = this.list(queryWrapper);
        return list.size() > 0;
    }

//    @Override
//    public void switchVideoSubscription(Integer id) {
//        Video video = this.getById(id);
//        if (video != null) {
//            Boolean onSubscription = video.getOnSubscription();
//            Boolean newValue;
//            if (onSubscription == null || onSubscription == false) {
//                newValue = false;
//            } else {
//                newValue = true;
//            }
//            UpdateWrapper<Video> updateWrapper = new UpdateWrapper<>();
//            updateWrapper.eq("id", id)
//                    .set("onSubscription", newValue);
//            this.update(updateWrapper);
//        }
//    }
}
