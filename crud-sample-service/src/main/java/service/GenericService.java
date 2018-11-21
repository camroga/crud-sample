package service;

import exception.DataNotFoundException;
import exception.ServiceException;

public abstract class GenericService<T, D> implements AbstractService<T, D> {

    @Override
    public D getData(final T param) {
        D data = null;
        try {
            this.validateParam(param);
            data = this.find(param);
        } catch (DataNotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }

        return data;
    }

    @Override
    public D getData() {
        D data;

        try {
            data = this.find();
        } catch (DataNotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }

        return data;
    }

}
