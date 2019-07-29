package com.stackroute.Muzixapp.exception;

import com.stackroute.Muzixapp.domain.Track;

public class TrackAlreadyExistsException extends Exception{

        private  String message;

        public TrackAlreadyExistsException()
        {
        }
        public TrackAlreadyExistsException(String message)
        {
            super(message);
            this.message=message;
        }
    }

