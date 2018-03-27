package yal.tabledessymboles;

public abstract class Entry {
    String name ;
    String type ;
    String etq  ;

    public Entry(String _name, String _type, String _etq) {
        name = _name ;
        type = _type ;
        etq  = _etq  ;
    }

    public String getName() {
        return name;
    }

    public String getEtq() {
        return etq;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Entry: " + name + " (" + type + ")" ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true ;

        if (obj == null) return false ;

        if (getClass() != obj.getClass()) return false ;

        Entry e = (Entry) obj ;
        return name.equals(e.getName()) ;
    }
}
