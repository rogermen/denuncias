package Control;
public class GeneradorMultiplicativo
{
    private VariableAleatoria var;

    public GeneradorMultiplicativo()
    {
        var = new VariableAleatoria();
    }

    public void contadorVariable(double num)
    {
        for(int i=0; i<20; i++)
        {
            System.out.println(var.exponencial(3));
        }
    }
}