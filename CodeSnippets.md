``` java
public class TjenesteB{
}

public class TjenesteC{
}

public class TjenesteA{
    private TjenesteB tjenesteB;
    private TjenesteC tjenesteC;
    
    public TjenesteA(){
        tjenesteB = new TjenesteB();
        tjenesteC = new TjenesteC();
    }
}
```

``` java
public class TjenesteB{
}

public class TjenesteC{
}

public class TjenesteA{
    private TjenesteB tjenesteB;
    private TjenesteC tjenesteC;
    
    public TjenesteA(TjenesteA tjenesteB, TjenesteB tjenesteC){
        this.tjenesteB = tjenesteB;
        this.tjenesteC = tjenesteC;
    }
}
```

``` java
public interface TjenesteB{
}

public interface TjenesteC{
}

public class TjenesteA{
    private TjenesteB tjenesteB;
    private TjenesteC tjenesteC;
    
    public TjenesteA(TjenesteA tjenesteB, TjenesteB tjenesteC){
        this.tjenesteB = tjenesteB;
        this.tjenesteC = tjenesteC;
    }
}
```