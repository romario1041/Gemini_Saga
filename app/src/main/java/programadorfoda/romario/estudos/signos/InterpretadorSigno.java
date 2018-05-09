package programadorfoda.romario.estudos.signos;
import java.util.ArrayList;

public class InterpretadorSigno {

    private ArrayList<Signo> signos = new ArrayList<Signo>(){{
        add(new Signo(20,1,18,2,"Aquário", "@drawable/aquarius"));
        add(new Signo(19,2,20,3,"Peixes", "@drawable/pisces"));
        add(new Signo(21,3,19,4, "Aries", "@drawable/aries"));
        add(new Signo(20,4,20,5,"Touro","@drawable/taurus"));
        add(new Signo(21,5,20,6,"Gêmeos", "@drawable/gemini"));
        add(new Signo(21,6,22,7,"Câncer","@drawable/cancer"));
        add(new Signo(23,7,22,8,"Leão","@drawable/leo"));
        add(new Signo(23,8,22,9,"Virgem", "@drawable/virgo"));
        add(new Signo(23,9,22,10,"Libra","@drawable/libra"));
        add(new Signo(23,10,21,11,"Escorpião", "drawable/scorpio"));
        add(new Signo(22,11,21,12,"Sagitário", "@drawable/sagittarius"));
        add(new Signo(22,12,19,1, "Capricórnio", "@drawable/capricorn"));
    }};

    public Signo interpretar(int dia, int mes){
        Signo signo = null;

        for(Signo s: signos){
            if(s.getMesInicio() == mes && dia >= s.getDiainicio()){
                signo = s;
            }else if(s.getMesfim() == mes && dia <= s.getDiafim()){
                signo = s;
            }
        }
        return signo;
    }
}
