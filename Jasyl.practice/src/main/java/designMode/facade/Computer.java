package designMode.facade;

/**
 * Created by jason on 16/5/30.
 */
public class Computer {

    CPU cpu;
    Memory memory;
    Disk disk;

    public Computer(){

        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }

    public void start(){
        cpu.startup();
        memory.startup();
        disk.startup();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
    }
}
