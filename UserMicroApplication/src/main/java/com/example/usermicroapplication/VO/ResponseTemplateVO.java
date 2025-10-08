package com.example.usermicroapplication.VO;

import com.example.usermicroapplication.models.ProviderDto;
import com.example.usermicroapplication.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    List<ProviderDto> provider;
}
