package model.api;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class PageResponse<T> {

    private int total;
    private List<T> result;

    /**
     * 结果正常时，使用此分页返回
     * @param total
     * @param list
     * @return
     * @param <T>
     */
    public static <T> PageResponse<T> buildCommonPageResponse(int total, List<T> list) {
        return new PageResponse<>(total, list);
    }

    /**
     * 结果异常时使用该进行返回
     * @return
     * @param <T>
     */
    public static <T> PageResponse<T> buildEmptyPageResponse() {
        return new PageResponse<>(0, new ArrayList<>());
    }

}
