package ru.digitalspirit.asaka.bpm.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CLIENT")
public class ClientEntity {

    @Id
    @GeneratedValue(generator = "SEQ_CLIENT")
    @SequenceGenerator(name = "SEQ_CLIENT", sequenceName = "SEQ_CLIENT", allocationSize = 1)
    @Column(name = "ID")
    private BigInteger id;
    @Column(name = "CLIENT_ABS_UID")
    private String clientUID;
    @Column(name = "CLIENT_ABS_ID")
    private String clientID;
    @Column(name = "CLIENT_CODE")
    private String clientCode;
    @Column(name = "CLIENT_CODE_CRM")
    private String clientCodeCrm;
    @Column(name = "FINAL_RISK_LEVEL")
    private String finalRiskLevel;
    @Column(name = "FULL_NAME")
    private String fullName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "PATRONYMIC")
    private String patronymic;
    @Column(name = "BIRTHDATE")
    private Date birthDate;
    @Column(name = "BIRTH_PLACE")
    private String placeOfBirth;
    @Column(name = "GENDER")
    private String sex;
    @Column(name = "CITIZENSHIP")
    private String citizenship;
    @Column(name = "INN")
    private String inn;
    @Column(name = "PINFL")
    private String pinFl;
    @OneToMany(targetEntity = DocumentEntity.class, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "CLIENT_ID")
    private List<DocumentEntity> documents;
    @OneToMany(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "CLIENT_ID")
    private List<AddressEntity> addresses;
    @Column(name = "REG_ADDR_EQ_RES_ADDR")
    private Boolean regAddrEqualseResAddr;
    @Column(name = "IS_COBORROWED")
    private Boolean isCoBorrowed;
    @OneToOne(fetch = FetchType.LAZY, targetEntity = PhoneEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "PHONEID", unique = true)
    private PhoneEntity phone;
    @OneToOne(fetch = FetchType.LAZY, targetEntity = JobInfoEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "JOBINFOID", unique = true)
    private JobInfoEntity jobInfo;
    @Column(name = "IS_ADDITIONAL_INCOME")
    private Boolean isAdditionalIncome;
    @OneToMany(targetEntity = AdditionalIncomeEntity.class, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "CLIENT_ID")
    private List<AdditionalIncomeEntity> additionalIncome;
    @Column(name = "IS_CAR")
    private Boolean isCar;
    @Column(name = "IS_REAL_ESTATE")
    private Boolean isRealEstate;
    @OneToMany(targetEntity = DepositInfoEntity.class, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "CLIENT_ID")
    private List<DepositInfoEntity> depositInfo;
    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;
    @Column(name = "CHILDREN_NUM_0_TO_3")
    private Integer childrenNum0To3;
    @Column(name = "CHILDREN_NUM_3_TO_16")
    private Integer childrenNum3To16;
    @Column(name = "ADULT_CHILDREN_NUM")
    private Integer adultChildrenNum;
    @Column(name = "EDUCATION")
    private String education;
    @Column(name = "TYPE_OF_HOUSING")
    private String TypeOfHousing;
    @Column(name = "IS_RETIREE")
    private Boolean isRetiree;
    @Column(name = "NINPS_ACCOUNT")
    private String ninpsAccount;
    @OneToMany(targetEntity = CurrentLoanEntity.class, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "CLIENT_ID")
    private List<CurrentLoanEntity> currentLoans;
    @OneToMany(targetEntity = RelatedPersonEntity.class, cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JoinColumn(name = "CLIENT_ID")
    private List<RelatedPersonEntity> relatedPersons;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ClientEntity that = (ClientEntity) o;

        return id != null ? id.equals(that) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}