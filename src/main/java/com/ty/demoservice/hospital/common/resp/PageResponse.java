package com.ty.demoservice.hospital.common.resp;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author xch
 * @date 2022-02-24 14:26
 * @since v1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class PageResponse<T> extends BaseResponse {

    private PageData<T> data;

    @Data
    @Builder
    public static class PageData<T> implements Serializable {
        private List<T> content;

        private Long page;

        private Long size;

        private Long total;
    }

    public PageResponse() {}

    public PageResponse(List<T> data) {
        this.data = PageData.<T>builder().content(data).build();
    }

    public PageResponse(List<T> data, long total, long page, long size) {
        this.data = PageData.<T>builder()
                .content(data)
                .total(total)
                .page(page)
                .size(size)
                .build();
    }

    public PageResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
