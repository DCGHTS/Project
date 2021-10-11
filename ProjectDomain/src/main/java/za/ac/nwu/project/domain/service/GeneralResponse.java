package za.ac.nwu.project.domain.service;

import java.io.Serializable;
import java.util.Objects;

public class GeneralResponse<T> implements Serializable
{
    private final boolean working;
    private final transient T showing;

    public GeneralResponse(boolean working, T showing)
    {
        this.working = working;
        this.showing = showing;
    }

    public boolean isWorking() { return working; }

    public T getShowing() { return showing; }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralResponse<?> that = (GeneralResponse<?>) o;
        return working == that.working && Objects.equals(showing, that.showing);
    }

    @Override
    public int hashCode() { return Objects.hash(working, showing); }

    @Override
    public String toString()
    {
        return "GeneralResponse{" + "successful=" + working + ", payloads=" + showing + "}";
    }
}
