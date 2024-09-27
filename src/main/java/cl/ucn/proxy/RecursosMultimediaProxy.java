package cl.ucn.proxy;

public class RecursosMultimediaProxy implements interfaz{
    private RecursosMultimedia recurso;
    private Usuario usuario;

    public RecursosMultimediaProxy(RecursosMultimedia recurso, Usuario usuario) {
        this.recurso = recurso;
        this.usuario = usuario;
    }

    public void mostrar() {
        if (puedeAcceder()) {
            recurso.mostrar();
        } else {
            System.out.println("Acceso denegado a: " + recurso.getNombre());
        }
    }

    private boolean puedeAcceder() {
        return !recurso.isProtegido() || (usuario != null && usuario.isTienePermiso());
    }

    @Override
    public boolean isProtegido() {
        return recurso.isProtegido();
    }
}
