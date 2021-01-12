# haiku-generator
The Haiku Generator is fed a series of pre-existing poems, and uses Markov chains to generate a large number of sentences from those poems. The text generated is then fed through a series of tests to determine which sequence of words are added to the final haiku. 

To start generating haikus, run HaikuMain.java
Note: FileAdjustments.java does not need to be ran. This file can be used if changes to the poem.txt file are made (or if you create your own list of poems to generate
the haikus from)

MarkovChain.java : open source code from https://rosettacode.org/wiki/Markov_chain_text_generator, under GNU Free Documentation License 1.2
SyllableCounter.java : from https://github.com/wfreitag/syllable-counter-java
