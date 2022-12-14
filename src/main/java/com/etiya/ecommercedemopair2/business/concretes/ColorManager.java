package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.ColorService;
import com.etiya.ecommercedemopair2.business.dtos.request.color.AddColorRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.color.AddColorResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Color;
import com.etiya.ecommercedemopair2.repository.abstracts.ColorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
    private ColorRepository colorRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<AddColorResponse> addColor(AddColorRequest addColorRequest) {

        Color color=modelMapperService.forRequest().map(addColorRequest,Color.class);
        Color savedColor =colorRepository.save(color);

        AddColorResponse response =
                modelMapperService.forResponse().map(savedColor,AddColorResponse.class);
        return new SuccessDataResult<AddColorResponse>(response,"Renk Eklendi.");
    }

    @Override
    public DataResult<Color> getById(int id) {
        return new SuccessDataResult<Color>(colorRepository.findById(id).orElseThrow(),"Id'ye göre listelendi.");
    }

    @Override
    public Page<Color> findAllWithPagination(Pageable pageable) {
        return colorRepository.findAll(pageable);
    }
}
