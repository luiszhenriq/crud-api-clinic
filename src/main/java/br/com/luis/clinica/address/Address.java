package br.com.luis.clinica.address;



import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @NotBlank
   private String street;
    @NotBlank
   private String district;
    @NotBlank
   private String city;
    @NotBlank
    @Pattern(regexp = "\\d{8}")
   private String cep;
   private String uf;
   private String number;


    public Address(Address address) {
        this.street = address.getStreet();
        this.district = address.getDistrict();
        this.city = address.getCity();
        this.cep = address.getCep();
        this.uf = address.getUf();
        this.number = address.getNumber();

    }

    public void updateInfo(Address address) {
        if (address.getStreet() != null) {
            this.street = address.getStreet();
        }
        if (address.getDistrict() != null) {
            this.street = address.getDistrict();
        }
        if (address.getCity() != null) {
            this.street = address.getCity();
        }
        if (address.getCep() != null) {
            this.street = address.getCep();
        }
        if (address.getUf() != null) {
            this.street = address.getUf();
        }
        if (address.getNumber() != null) {
            this.street = address.getNumber();
        }

    }
}

