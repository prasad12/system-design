package com.sd.parkinglot.model;

import com.sd.parkinglot.enums.GateType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Gate {
    protected final Integer id;

    public abstract GateType getType();
}
