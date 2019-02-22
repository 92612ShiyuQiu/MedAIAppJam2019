package com.example.medaijam;

class RandomForestClassifier {
    public static int predict_0(double[] features) {
        int[] classes = new int[2];
        
        if (features[4] <= 0.07692307978868484) {
            classes[0] = 13; 
            classes[1] = 0; 
        } else {
            classes[0] = 0; 
            classes[1] = 37; 
        }
        int class_idx = 0;
        int class_val = classes[0];
        for (int i = 1; i < 2; i++) {
            if (classes[i] > class_val) {
                class_idx = i;
                class_val = classes[i];
            }
        }
        return class_idx;
    }
    
    public static int predict_1(double[] features) {
        int[] classes = new int[2];
        
        if (features[0] <= 135.2083282470703) {
            if (features[1] <= 86.79167175292969) {
                classes[0] = 17; 
                classes[1] = 0; 
            } else {
                classes[0] = 0; 
                classes[1] = 1; 
            }
        } else {
            classes[0] = 0; 
            classes[1] = 32; 
        }
        int class_idx = 0;
        int class_val = classes[0];
        for (int i = 1; i < 2; i++) {
            if (classes[i] > class_val) {
                class_idx = i;
                class_val = classes[i];
            }
        }
        return class_idx;
    }
    
    public static int predict_2(double[] features) {
        int[] classes = new int[2];
        
        if (features[4] <= 0.07692307978868484) {
            classes[0] = 22; 
            classes[1] = 0; 
        } else {
            classes[0] = 0; 
            classes[1] = 28; 
        }
        int class_idx = 0;
        int class_val = classes[0];
        for (int i = 1; i < 2; i++) {
            if (classes[i] > class_val) {
                class_idx = i;
                class_val = classes[i];
            }
        }
        return class_idx;
    }
    
    public static int predict_3(double[] features) {
        int[] classes = new int[2];
        
        if (features[0] <= 129.41665649414062) {
            classes[0] = 13; 
            classes[1] = 0; 
        } else {
            classes[0] = 0; 
            classes[1] = 37; 
        }
        int class_idx = 0;
        int class_val = classes[0];
        for (int i = 1; i < 2; i++) {
            if (classes[i] > class_val) {
                class_idx = i;
                class_val = classes[i];
            }
        }
        return class_idx;
    }
    
    public static int predict_4(double[] features) {
        int[] classes = new int[2];
        
        if (features[4] <= 0.11538461595773697) {
            classes[0] = 19; 
            classes[1] = 0; 
        } else {
            classes[0] = 0; 
            classes[1] = 31; 
        }
        int class_idx = 0;
        int class_val = classes[0];
        for (int i = 1; i < 2; i++) {
            if (classes[i] > class_val) {
                class_idx = i;
                class_val = classes[i];
            }
        }
        return class_idx;
    }
    
    public static int predict_5(double[] features) {
        int[] classes = new int[2];
        
        if (features[3] <= 11.342618942260742) {
            classes[0] = 19; 
            classes[1] = 0; 
        } else {
            classes[0] = 0; 
            classes[1] = 31; 
        }
        int class_idx = 0;
        int class_val = classes[0];
        for (int i = 1; i < 2; i++) {
            if (classes[i] > class_val) {
                class_idx = i;
                class_val = classes[i];
            }
        }
        return class_idx;
    }
    
    public static int predict_6(double[] features) {
        int[] classes = new int[2];
        
        if (features[3] <= 12.131797790527344) {
            classes[0] = 21; 
            classes[1] = 0; 
        } else {
            classes[0] = 0; 
            classes[1] = 29; 
        }
        int class_idx = 0;
        int class_val = classes[0];
        for (int i = 1; i < 2; i++) {
            if (classes[i] > class_val) {
                class_idx = i;
                class_val = classes[i];
            }
        }
        return class_idx;
    }
    
    public static int predict_7(double[] features) {
        int[] classes = new int[2];
        
        if (features[4] <= 0.11538461595773697) {
            classes[0] = 20; 
            classes[1] = 0; 
        } else {
            classes[0] = 0; 
            classes[1] = 30; 
        }
        int class_idx = 0;
        int class_val = classes[0];
        for (int i = 1; i < 2; i++) {
            if (classes[i] > class_val) {
                class_idx = i;
                class_val = classes[i];
            }
        }
        return class_idx;
    }
    
    public static int predict_8(double[] features) {
        int[] classes = new int[2];
        
        if (features[0] <= 132.5833282470703) {
            classes[0] = 23; 
            classes[1] = 0; 
        } else {
            classes[0] = 0; 
            classes[1] = 27; 
        }
        int class_idx = 0;
        int class_val = classes[0];
        for (int i = 1; i < 2; i++) {
            if (classes[i] > class_val) {
                class_idx = i;
                class_val = classes[i];
            }
        }
        return class_idx;
    }
    
    public static int predict_9(double[] features) {
        int[] classes = new int[2];
        
        if (features[4] <= 0.07692307978868484) {
            classes[0] = 16; 
            classes[1] = 0; 
        } else {
            classes[0] = 0; 
            classes[1] = 34; 
        }
        int class_idx = 0;
        int class_val = classes[0];
        for (int i = 1; i < 2; i++) {
            if (classes[i] > class_val) {
                class_idx = i;
                class_val = classes[i];
            }
        }
        return class_idx;
    }
    
    public static int predict(double[] features) {
        int n_classes = 2;
        int[] classes = new int[n_classes];
        classes[RandomForestClassifier.predict_0(features)]++;
        classes[RandomForestClassifier.predict_1(features)]++;
        classes[RandomForestClassifier.predict_2(features)]++;
        classes[RandomForestClassifier.predict_3(features)]++;
        classes[RandomForestClassifier.predict_4(features)]++;
        classes[RandomForestClassifier.predict_5(features)]++;
        classes[RandomForestClassifier.predict_6(features)]++;
        classes[RandomForestClassifier.predict_7(features)]++;
        classes[RandomForestClassifier.predict_8(features)]++;
        classes[RandomForestClassifier.predict_9(features)]++;
    
        int class_idx = 0;
        int class_val = classes[0];
        for (int i = 1; i < n_classes; i++) {
            if (classes[i] > class_val) {
                class_idx = i;
                class_val = classes[i];
            }
        }
        return class_idx;
    }

    public static void main(String[] args) {
        if (args.length == 5) {

            // Features:
            double[] features = new double[args.length];
            for (int i = 0, l = args.length; i < l; i++) {
                features[i] = Double.parseDouble(args[i]);
            }

            // Prediction:
            int prediction = RandomForestClassifier.predict(features);
            System.out.println(prediction);

        }
    }
}
