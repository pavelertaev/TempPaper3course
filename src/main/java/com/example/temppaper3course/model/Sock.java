package com.example.temppaper3course.model;


import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sock {

    private Color color;
    private Size size;
    private int cottonPart;

    public enum Color {
        Black, Red, Blue, Yellow, Grey;

    }

    public enum Size {


        SIZE_28(28), SIZE_30(30), SIZE_34(34), SIZE_32(32), SIZE_36(36);
        private final int size;

        Size(int size) {
            this.size = size;
        }

        @JsonValue
        public int getSize() {
            return size;
        }


    }

    public static Color convertColor(String color) {
        return switch (color) {
            case "Black" -> Color.Black;
            case "Red" -> Color.Red;
            case "Blue" -> Color.Blue;
            case "Yellow" -> Color.Yellow;
            case "Grey" -> Color.Grey;
            default -> throw new IllegalArgumentException();
        };
    }

    public static Size sizeConvertor(int size) {
        return switch (size) {
            case 28 -> Size.SIZE_28;
            case 30 -> Size.SIZE_30;
            case 32 -> Size.SIZE_32;
            case 34 -> Size.SIZE_34;
            case 36 -> Size.SIZE_36;
            default -> throw new IllegalArgumentException();
        };
    }

}
