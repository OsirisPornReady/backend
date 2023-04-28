package org.osiris.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import org.osiris.backend.entity.Video;
import org.osiris.backend.mapper.VideoMapper;
import org.osiris.backend.service.VideoService;

@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

//    private final SimpleDateFormat sdf;
//    private final VideoMapper videoMapper;
//
//    @Autowired(required = false)
//    public VideoService(VideoMapper videoMapper) {
//        this.videoMapper = videoMapper;
//        this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    }
//
//    public List<VideoType> getSelectList() {
//
//        List<VideoType> list = new ArrayList<>();
//
//        list.add(new VideoType("Japanese", "1"));
//        list.add(new VideoType("Westworld", "2"));
//        list.add(new VideoType("Chinese", "3"));
//
//        return list;
//    }
//
//
//    public void add() {
//        Video video = new Video();
//        video.setTitle("测试视频");
//        video.setSerialNumber("test serial");
//        video.setVideoType(1);
//        video.setArea(1);
//
//        Date date = null;
//        try {
//            date = sdf.parse("2023-04-22 00:00:00");
//        } catch (
//                ParseException e) {
//            e.printStackTrace();
//        }
//        video.setPublishTime(date);
//
//        try {
//            date = sdf.parse("2023-04-25 00:00:00");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        video.setAddTime(date);
//        video.setDescription("简单描述测试");
//
//        videoMapper.selectList(null);
//
//        System.out.println("insert test");
//    }

}
