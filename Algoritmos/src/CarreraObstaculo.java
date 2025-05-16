public class CarreraObstaculo {

    public static void main(String[] args) {
        // Ejemplo de uso
        String[] acciones = {"run", "jump", "run", "jump"};
        String pista = "__|__|__";

        boolean resultado = evaluarCarrera(acciones, pista);
        System.out.println("¿El atleta ha superado la carrera? " + resultado);
    }

    public static boolean evaluarCarrera(String[] acciones, String pista) {
        // Convertir la pista a un StringBuilder para modificarla
        StringBuilder pistaModificada = new StringBuilder(pista);

        // Verificar que el número de acciones coincida con la longitud de la pista
        if (acciones.length != pista.length()) {
            throw new IllegalArgumentException("El número de acciones debe coincidir con la longitud de la pista.");
        }

        // Evaluar cada acción en la pista
        for (int i = 0; i < acciones.length; i++) {
            String accion = acciones[i];
            char tramo = pista.charAt(i);

            if (accion.equals("run") && tramo == '_') {
                // Acción correcta, no se modifica la pista
                continue;
            } else if (accion.equals("jump") && tramo == '|') {
                // Acción correcta, no se modifica la pista
                continue;
            } else if (accion.equals("jump") && tramo == '_') {
                // Acción incorrecta, se modifica la pista
                pistaModificada.setCharAt(i, 'x');
            } else if (accion.equals("run") && tramo == '|') {
                // Acción incorrecta, se modifica la pista
                pistaModificada.setCharAt(i, '/');
            } else {
                // Acción no válida
                throw new IllegalArgumentException("Acción no válida: " + accion);
            }
        }

        // Imprimir la pista modificada
        System.out.println("Pista final: " + pistaModificada.toString());

        // Si todas las acciones fueron correctas, el atleta ha superado la carrera
        return pistaModificada.toString().equals(pista);
    }
}
