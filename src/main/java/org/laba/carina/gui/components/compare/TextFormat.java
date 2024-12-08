package org.laba.carina.gui.components.compare;

public class TextFormat {
    public enum Type {
        BOLD("'''"),
        ITALIC("''");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
