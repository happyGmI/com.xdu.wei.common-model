package model.api;

import enums.ApiEnum;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class ApiResponse<T> {

    private Integer status;

    private Integer errorCode;

    private String errorMessage;

    private T data;

    /**
     * 成功空结果返回
     * @return
     */
    public static ApiResponse<Object> buildEmptySuccessResponse() {
        return new ApiResponse<>(
                ApiEnum.SUCCESS.getStatus(),
                ApiEnum.SUCCESS.getErrCode(),
                ApiEnum.SUCCESS.getMessage(),
                null
        );
    }

    /**
     * 任意数据返回
     * @param data
     * @return
     * @param <T>
     */
    public static <T> ApiResponse<T> buildResultSuccessResponse(T data) {
        return new ApiResponse<>(
                ApiEnum.SUCCESS.getStatus(),
                ApiEnum.SUCCESS.getErrCode(),
                ApiEnum.SUCCESS.getMessage(),
                data
        );
    }

    /**
     * 分页结果返回
     * @param total
     * @param list
     * @return
     * @param <T>
     */
    public static <T> ApiResponse<PageResponse<T>> buildPageSuccessResponse(int total, List<T> list) {
        PageResponse<T> data = PageResponse.buildCommonPageResponse(total, list);
        return new ApiResponse<>(
                ApiEnum.SUCCESS.getStatus(),
                ApiEnum.SUCCESS.getErrCode(),
                ApiEnum.SUCCESS.getMessage(),
                data
        );
    }

    /**
     * 内部异常，正常空返回
     * @return
     */
    public static ApiResponse<Object> buildInternFailResponse() {
        return new ApiResponse<>(
                ApiEnum.COMMON_FAIL.getStatus(),
                ApiEnum.COMMON_FAIL.getErrCode(),
                ApiEnum.COMMON_FAIL.getMessage(),
                null
        );
    }

    /**
     * 内部异常，分页空返回
     * @return
     */
    public static ApiResponse<PageResponse<Object>> buildPageInternFailResponse() {
        PageResponse<Object> data = PageResponse.buildEmptyPageResponse();
        return new ApiResponse<>(
                ApiEnum.COMMON_FAIL.getStatus(),
                ApiEnum.COMMON_FAIL.getErrCode(),
                ApiEnum.COMMON_FAIL.getMessage(),
                data
        );
    }

    /**
     * 系统已知错误，返回错误信息
     * @param errorMessage
     * @return
     */
    public static ApiResponse<Object> buildKnownFailRemindResponse(String errorMessage) {
        return new ApiResponse<>(
                ApiEnum.KNOWN_FAIL.getStatus(),
                ApiEnum.KNOWN_FAIL.getErrCode(),
                errorMessage,
                null
        );
    }

    public static void main(String[] args) {
        System.out.println(ApiResponse.buildPageSuccessResponse(10, new ArrayList<>()));
    }
}

