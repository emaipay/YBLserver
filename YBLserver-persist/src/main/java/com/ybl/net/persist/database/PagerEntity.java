package com.ybl.net.persist.database;

import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class PagerEntity {
	
	@Transient
    private Integer page = 1;

    @Transient
    private Integer rows = 10;

}
