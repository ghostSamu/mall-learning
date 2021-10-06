package com.example.demo.dto;

import com.example.demo.mbg.model.UmsMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class UmsMenuNode extends UmsMenu {
    @ApiModelProperty(value = "自己菜单")
    private List<UmsMenuNode> children;
}
