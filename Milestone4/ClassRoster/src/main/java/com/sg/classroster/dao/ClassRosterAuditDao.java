/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

/**
 *
 * @author mohammedchowdhury
 */


import com.sg.classroster.dao.ClassRosterPersistenceException;

public interface ClassRosterAuditDao {
    
   
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException;
   
}