package io.genjitsu;

import io.genjitsu.factories.GenJitsuFactory;

import java.util.List;
import java.util.Random;

/**
 * Created by bcowdery on 6/28/2017.
 */
public class GenJitsu {

    public static <T> void configure() {

    }


    public static class A {

        private static Random random = new Random();
        private static FillerManager fillerManager = new FillerManager();

        /**
         * Returns a new instance of a given type, populated with values.
         * @param <T> type
         * @return populated instance
         */
        public static <T> T newInstance() {
            T instance = new GenJitsuFactory<T>().createInstance();
            return newInstance(instance);
        }

        /**
         * Populates an instance of an object with values.
         * @param instance
         * @param <T>
         * @return
         */
        public static <T> T newInstance(T instance) {
            // todo: fill instance
            return instance;
        }

        /**
         *
         * @param count
         * @param <T>
         * @return
         */
        public static <T> List<T> listOf(int count) {
            // return new ListBuilder;
            return null;
        }
    }
}
