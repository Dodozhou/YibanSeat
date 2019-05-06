package com.star.service;

import com.google.zxing.WriterException;
import com.star.entity.Seat;
import com.star.mapper.SeatMapper;
import com.star.util.AESUtil;
import com.star.util.QrCodeCreateUtil;
import sun.misc.BASE64Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class SeatService {
    @Autowired
    SeatMapper seatMapper;

    @Value("${aes.passwd}")
    private  String AESPassWd;

    @Cacheable(value = "seatCache",key = "#p0")
    public List<String> getSeatsBySpeach(int speachId){
        return seatMapper.getBySepach(speachId);
    }

    @Cacheable(value = "seatCache")
    public List<Seat> getByOwnerAndSpeach(int owner,int speach){
        return seatMapper.getByOwnerAndSpeach(owner,speach);
    }

    @Cacheable(value = "seatCache")
    public int getCountBySeatNumAndSpeach(String seatNum,int speachId){
        return seatMapper.getCountBySeatNumAndSpeach(seatNum,speachId);
    }

    @CacheEvict(value = "seatCache",allEntries = true)
    public void add(Seat seat){
        seatMapper.add(seat);
    }

    @CacheEvict(value = "seatCache",allEntries = true)
    public void deleteByOwner(int owner, int speachId){
        seatMapper.deleteByOwner(owner,speachId);
    }

    //图片太大，耗费内存，且该接口并不常用，所以不进行缓存
    //@Cacheable(value = "seatCache")
    public String getMyQrcode(int userId, int speachId,String seatNum) throws IOException, WriterException {
        StringBuilder builder = new StringBuilder();
        String content;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        //拼接二维码内容
        builder.append(speachId).append(";");
        builder.append(userId).append(";");
        builder.append(seatNum).append(";");

        //加密二维码内容
        content = AESUtil.encrypt(builder.toString(), AESPassWd);

        //生成并返回二维码
        QrCodeCreateUtil.createQrCode(outputStream,content,900,"JPEG");

        //base64编码
        BASE64Encoder encoder = new BASE64Encoder();

        return encoder.encode(outputStream.toByteArray());
    }

    /**
     * 更新座位签到情况
     * @param sign true已签到 false未签到
     * @param speachId 活动ID
     * @param seatNum 座位号
     */
    @CacheEvict(value = "seatCache",allEntries = true)
    public void updateSeatSign(boolean sign,int speachId, String seatNum){
        seatMapper.updateSeatSign(sign,speachId,seatNum);
    }


}
