/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.leonardo.simpleapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.leonardo.simpleapp.domain.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Long> {

    

}
