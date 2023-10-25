package ait.computer.dao;/*
 * Copyright (c) 2023.
 *  Igor Volotovskyi
 */

import ait.computer.model.Computer;

public interface Shop {
    boolean addComputer (Computer computer);

    int quantity();
    Computer removeComputer (int article);
    Computer findComputer (int article);
}
