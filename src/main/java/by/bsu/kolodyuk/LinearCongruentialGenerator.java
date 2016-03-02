package by.bsu.kolodyuk;


import org.apache.commons.math3.random.AbstractRandomGenerator;

public class LinearCongruentialGenerator extends AbstractRandomGenerator {

    private long multiplier;
    private long addend;
    private long mask;

    private long oldseed;

    public LinearCongruentialGenerator() {
        this(0, 1664525, 1013904223, 1L << 32);
    }

    public LinearCongruentialGenerator(long seed, long multiplier, long addend, long mask) {
        this.oldseed = seed;
        this.multiplier = multiplier;
        this.addend = addend;
        this.mask = mask;
    }

    @Override
    public void setSeed(long seed) {
        this.oldseed = seed;
    }

    @Override
    public double nextDouble() {
        oldseed = (multiplier * oldseed + addend) % mask;
        return (double)oldseed / mask;
    }
}
