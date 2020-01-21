2 Main files

Clean Data.ipynb

takes the data from the downloaded JSON and then cleans it, removes stopwords and then outputs it to cleaned_data.csv

Doc2Vec Model

Takes the cleaned data and builds a gensim model using Doc2Vec.
Then it uses the model to attempt to predict similar recipes using a keyword.
