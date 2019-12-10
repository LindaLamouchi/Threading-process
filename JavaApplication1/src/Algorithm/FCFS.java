package Algorithm;

import Items.Job;
import Items.Queue;

/**
 * "First Come First served" 
 */
public class FCFS extends MyAlgorithm{
     
    /**
     *  initialisation lists
     * @param workQueue queue des processus
     */
    public FCFS(Queue workQueue)
    {  
        super(workQueue); 
    }
    
    /**
     * shows what happen in a single step when using this algorithm
     * @param simulationTime current time of this simulation
     * @return job the CPU was working on
     */
    @Override
    public Job nextStep (int simulationTime)
    {
        updateReadyQueue(simulationTime);  // ajout a la file d'attente
        if(!busy) // kn CPU fer8a 
        {
            if(readyQueue.isEmpty()) {return null;} 
            busy = true; 
            setCurrentJob(); // execution puisque la file est vide
        }
        return workInCPU(simulationTime);//retourn le temps d'exe
    }
    
    /**
     * work the current job in the CPU for one simulation time step
     * @param simulationTime current time of the simulation
     * @return the current job the CPU is working on
     */
    @Override
    protected Job workInCPU(int simulationTime)
    {
        currentJob.jobWorked(simulationTime); 
        if(currentJob.getRemainTime() == 0) {busy = false;} // change le bool a 0 si on a terminer l'execution
        return currentJob; 
    }
    
   
}
