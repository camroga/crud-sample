package service;

public interface AbstractService<T, D> {

    D getData(T param);

    D getData();

    D find(T param);

    D find();

    void validateParam(T param);
}
