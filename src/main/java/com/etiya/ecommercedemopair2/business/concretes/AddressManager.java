package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.AddressService;
import com.etiya.ecommercedemopair2.business.abstracts.CountryService;
import com.etiya.ecommercedemopair2.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.address.ListAddressResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Address;
import com.etiya.ecommercedemopair2.entities.concretes.Country;
import com.etiya.ecommercedemopair2.repository.abstracts.AddressRepository;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {

    private AddressRepository addressRepository;
    private CountryService countryService;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<AddAddressResponse> addAddress(AddAddressRequest addAddressRequest) {

        Address address=modelMapperService.forRequest().map(addAddressRequest,Address.class);

        Address savedAddress=addressRepository.save(address);

        AddAddressResponse response=
                modelMapperService.forResponse().map(savedAddress,AddAddressResponse.class);
        return new SuccessDataResult<AddAddressResponse>(response,"Adres eklendi.");
    }

    @Override
    public DataResult<Address> getById(int address_id) {
        //return addressRepository.findById(address_id).orElseThrow();
        return new SuccessDataResult<Address>
                (this.checkIfAddressExistsById(address_id).getData(),"Data getirildi.");

    }

    @Override
    public Page<Address> findAllWithPagination(Pageable pageable) {
        return addressRepository.findAll(pageable);
    }

    @Override
    public Page<ListAddressResponse> findAllWithPaginationDto(Pageable pageable) {
        return addressRepository.getAllListAddress(pageable);
    }

    private DataResult<Address> checkIfAddressExistsById(int address_id) {
        Address currentAddress = this.addressRepository.findById(address_id).orElseThrow();
        return new SuccessDataResult<Address>(currentAddress);

    }
}
