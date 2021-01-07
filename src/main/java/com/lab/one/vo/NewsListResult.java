package com.lab.one.vo;

import com.lab.one.utils.DateUtil;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author simeixue
 * @date 2021/1/6
 */

@Data
@Accessors(chain = true)
public class NewsListResult {

    private String id;

    private String title;

    private Date createTime;

    public String getCreateTimeStr() {
        return DateUtil.getNormalTimeStr(createTime);
    }
}
