package com.hong;

import com.hong.GUI.Frame;

import javax.swing.*;

public class App
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(Frame::new);
    }
}
