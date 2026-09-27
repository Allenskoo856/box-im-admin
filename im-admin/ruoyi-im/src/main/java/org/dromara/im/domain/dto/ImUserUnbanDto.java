package org.dromara.im.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
/**
 * @author: Blue
 * @date: 2024-07-14
 * @version: 1.0
 */
@Schema(description = "用户解锁")
public class ImUserUnbanDto {

    @NotNull(message = "用户id不可为空")
    @Schema(description = "用户id")
    private Long id;


    public ImUserUnbanDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
