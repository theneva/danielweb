package com.wact.daniel.people;

public class PersonNotFoundException extends RuntimeException
{
    public PersonNotFoundException(final String message)
    {
        super(message);
    }
}
