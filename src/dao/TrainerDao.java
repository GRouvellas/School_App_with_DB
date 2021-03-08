/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Trainer;

/**
 *
 * @author Geo
 */
public interface TrainerDao {

    public void insertTrainer(Trainer t);

    public void allTrainers();
    
    public Trainer createTrainer();

}
