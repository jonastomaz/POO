package solucao;

import vetor.Ponto;
import vetor.Vetor;

public class SolucaoPassoAPasso {

    public void mostrarSoma(Vetor v1, Vetor v2, Vetor resultado) {
        System.out.println("\n===== PASSO A PASSO - SOMA =====");
        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);
        System.out.println("\nSomamos cada coordenada:");
        System.out.println("x: " + v1.getX() + " + " + v2.getX()+ " = " + resultado.getX());
        System.out.println("y: " + v1.getY() + " + " + v2.getY()+ " = " + resultado.getY());
        System.out.println("z: " + v1.getZ() + " + " + v2.getZ()+ " = " + resultado.getZ());
        System.out.println("\nResultado: " + resultado);
    }

    public void mostrarSubtracao(Vetor v1, Vetor v2, Vetor resultado) {
        System.out.println("\n===== PASSO A PASSO - SUBTRAÇÃO =====");
        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);
        System.out.println("\nSubtraímos cada coordenada:");
        System.out.println("x: " + v1.getX() + " - " + v2.getX()+ " = " + resultado.getX() );
        System.out.println("y: " + v1.getY() + " - " + v2.getY() + " = " + resultado.getY());
        System.out.println("z: " + v1.getZ() + " - " + v2.getZ()+ " = " + resultado.getZ());
        System.out.println("\nResultado: " + resultado);
    }

    public void mostrarEscalar(Vetor vetor,double escalar, Vetor resultado) {
        System.out.println("\n===== PASSO A PASSO - ESCALAR =====");
        System.out.println("Vetor = " + vetor);
        System.out.println("Escalar = " + escalar);
        System.out.println("\nMultiplicamos cada coordenada:");
        System.out.println("x: " + vetor.getX() + " × " + escalar+ " = " + resultado.getX());
        System.out.println("y: " + vetor.getY() + " × " + escalar+ " = " + resultado.getY() );
        System.out.println("z: " + vetor.getZ() + " × " + escalar+ " = " + resultado.getZ());
        System.out.println("\nResultado: " + resultado);
    }

    public void mostrarProdutoEscalar( Vetor v1,Vetor v2,double resultado) {
        System.out.println("\n===== PASSO A PASSO - PRODUTO ESCALAR =====");
        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);
        System.out.println("\nFórmula:");
        System.out.println( "v1 · v2 = x1×x2 + y1×y2 + z1×z2");

        double x = v1.getX() * v2.getX();
        double y = v1.getY() * v2.getY();
        double z = v1.getZ() * v2.getZ();

        System.out.println( v1.getX() + "×" + v2.getX()+ " + " + v1.getY() + "×" + v2.getY() + " + "+ v1.getZ() + "×" + v2.getZ());
        System.out.println(x + " + " + y + " + " + z);
        System.out.println("\nResultado = " + resultado);
    }

    public void mostrarProdutoVetorial(Vetor v1,Vetor v2, Vetor resultado) {
        System.out.println("\n===== PASSO A PASSO - PRODUTO VETORIAL =====");
        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);

        double x = v1.getY() * v2.getZ()- v1.getZ() * v2.getY();
        double y = v1.getZ() * v2.getX()- v1.getX() * v2.getZ();
        double z = v1.getX() * v2.getY() - v1.getY() * v2.getX();

        System.out.println("\nx = y1×z2 - z1×y2");
        System.out.println("x = " + x);
        System.out.println("\ny = z1×x2 - x1×z2");
        System.out.println("y = " + y);
        System.out.println("\nz = x1×y2 - y1×x2");
        System.out.println("z = " + z);
        System.out.println("\nResultado = " + resultado);
    }

    public void mostrarModulo(Vetor vetor,double resultado) {
        System.out.println("\n===== PASSO A PASSO - MÓDULO =====");
        System.out.println("Vetor = " + vetor);
        System.out.println("\nFórmula:");
        System.out.println( "|v| = V(x² + y² + z²)");
        System.out.println("|v| = v(" + vetor.getX() + "² + " + vetor.getY() + "² + " + vetor.getZ() + "²)" );
        System.out.println("\nResultado = " + resultado);
    }


    public void mostrarOrtogonalidade(Vetor v1,Vetor v2,double produtoEscalar, boolean resultado) {
        System.out.println("\n===== PASSO A PASSO - SE VETORES SAO ORTOGONAIS =====");
        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);
        System.out.println("\nCalculamos o produto escalar:");
        System.out.println("v1 · v2 = " + produtoEscalar);
        System.out.println("\nRegra:");
        System.out.println("Se o produto escalar = 0, os vetores são ortogonais.");

        if (resultado) {
            System.out.println("\nOs vetores SÃO ortogonais.");
        } else {
            System.out.println("\nOs vetores NÃO são ortogonais.");
        }
    }

    public void mostrarParalelismo(Vetor v1,Vetor v2,Vetor produtoVetorial,boolean resultado) {
        System.out.println("\n===== PASSO A PASSO - VETORES PARALELOS =====");
        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);
        System.out.println("\nCalculamos o produto vetorial:" );
        System.out.println("v1 × v2 = " + produtoVetorial);
        System.out.println( "Se o produto vetorial for o vetor nulo, os vetores são paralelos.");

        if (resultado) {
            System.out.println("Os vetores SÃO paralelos.");
        } else {
            System.out.println("Os vetores NÃO são paralelos.");
        }
    }

    public void mostrarVetorParalelo(Vetor vetor,double escalar,Vetor resultado) {
        System.out.println("\n===== PASSO A PASSO - VETOR PARALELO =====");
        System.out.println("Vetor original = " + vetor);
        System.out.println("Escalar = " + escalar);
        System.out.println("\nMultiplicamos:");
        System.out.println("v' = " + escalar + " × " + vetor );
        System.out.println("\nResultado = " + resultado);
    }

    public void mostrarAngulo(Vetor v1, Vetor v2, double produtoEscalar,double modulo1,double modulo2,double angulo) {
        System.out.println("\n===== PASSO A PASSO - ÂNGULO =====");
        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);
        System.out.println("\nFórmula:");
        System.out.println("cos(θ) = (v1 · v2) / (|v1| × |v2|)" );
        System.out.println( "\nv1 · v2 = " + produtoEscalar);
        System.out.println( "|v1| = " + modulo1);
        System.out.println("|v2| = " + modulo2);
        System.out.println("\nθ = " + angulo + " graus");
    }

    public void mostrarPontoAtravésDeVetor(Ponto ponto,Vetor vetor,Ponto resultado) {
        System.out.println( "\n===== PASSO A PASSO - PONTO ATRAVÉS DE VETOR =====");
        System.out.println("Ponto = " + ponto);
        System.out.println("Vetor = " + vetor);
        System.out.println("\nSomamos as coordenadas:");
        System.out.println("x: " + ponto.getX()+ " + " + vetor.getX() + " = " + resultado.getX());
        System.out.println("y: " + ponto.getY()+ " + " + vetor.getY()+ " = " + resultado.getY());
        System.out.println("z: " + ponto.getZ()+ " + " + vetor.getZ()+ " = " + resultado.getZ());
        System.out.println("\nNovo ponto = " + resultado);
    }

    public void mostrarEquacaoVetorial(Ponto ponto,Vetor vetor) {
        System.out.println("\n===== PASSO A PASSO - EQUAÇÃO VETORIAL =====" );
        System.out.println("Ponto inicial = " + ponto);
        System.out.println("Vetor diretor = " + vetor);
        System.out.println("\nEquação vetorial:");
        System.out.println("P = P0 + t × v");
        System.out.println("P = (" + ponto.getX() + ", "+ ponto.getY() + ", "+ ponto.getZ() + ") "
            		+ "+ t(" + vetor.getX() + ", "+ vetor.getY() + ", "+ vetor.getZ() + ")");
        System.out.println("\nEquação paramétrica:");
        System.out.println("x = " + ponto.getX()+ " + " + vetor.getX() + "t");
        System.out.println("y = " + ponto.getY() + " + " + vetor.getY() + "t");
        System.out.println( "z = " + ponto.getZ() + " + " + vetor.getZ() + "t");
    }

    public void mostrarUnitario(Vetor vetor,double modulo,Vetor resultado) {
        System.out.println("\n===== PASSO A PASSO - VETOR UNITÁRIO =====");
        System.out.println("Vetor = " + vetor);
        System.out.println("\nPrimeiro calculamos o módulo:" );
        System.out.println("|v| = " + modulo);
        System.out.println("\nDepois dividimos cada coordenada pelo módulo:");
        System.out.println( "x = " + vetor.getX()+ " / " + modulo + " = " + resultado.getX());
        System.out.println("y = " + vetor.getY()+ " / " + modulo + " = " + resultado.getY() );
        System.out.println("z = " + vetor.getZ()+ " / " + modulo+ " = " + resultado.getZ());
        System.out.println("\nVetor unitário = " + resultado);
    }
}
