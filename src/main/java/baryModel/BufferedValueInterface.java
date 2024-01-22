package baryModel;

//for calculating values bufferedly
public interface BufferedValueInterface {
    void precalculate(double time);
    void update();
}