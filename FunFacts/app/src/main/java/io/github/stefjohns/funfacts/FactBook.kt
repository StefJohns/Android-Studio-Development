package io.github.stefjohns.funfacts

import java.util.*

class FactBook {
    // Properties
    private val facts = arrayOf(
            "The longest time between two twins being born is 87 days.",
            "In 2007, an American man named Corey Taylor tried to fake his own death in order to get out of his cell phone contract without paying a fee. It didn't work.",
            "Light doesn't necessarily travel at the speed of light. The slowest we've ever recorded light moving is at 38 mph.",
            "The Dutch village of Giethoorn has no roads; its buildings are connected entirely by canals and footbridges.",
            "Powerful earthquakes can permanently shorten the length of Earth's day, by moving the spin of the Earth's axis. The 2011 Japan earthquake knocked 1.8 microseconds off our days. The 2004 Sumatra quake cost us around 6.8 microseconds.",
            "There is a glacier called \"Blood Falls\" in Antarctica that regularly pours out red liquid, makng it look like the ice is bleeding. (It's actually oxidised salt water.)",
            "In 2008 scientists discovered a new species of bacteria that lives in hairspray.",
            "The top of the Eiffel Tower leans away from the sun, as the metal facing the sun heats up and expands. It can move as much as 7 inches.",
            "The tiny parasite Toxoplasma gondii can only breed sexually when in the guts of a cat. To this end, when it infects rats, it changes their behavior to make them less scared of cats.",
            "The katzenklavier(\"cat piano\") was a musical instrument made out of cats. Designed by 17th century German scholar Anthanasius Kircher, it consisted of a row of caged cats with different voice pitches, who could be \"played\" by a keyboardist driving nails into their tails. Talk about animal cruelty.",
            "The Romans used to clean and whiten their teeth with urine. Apparently it works. Please don't do it though.",
            "There are around 60,000 miles of blood vessels in the human body and if removed would wrap around the world more than twice.",
            "Some fruit flies are genetically resistant to getting drunk - but only if they have an inactive version of a gene scientists has named \"happyhour\"",
            "In 1567, the man said to have had the longest beard in the world dies after he tripped over his beard running away from a fire.",
            "In 1993, San Francisco held a referendum over whether a police office called Bob Geary was allowed to patrol while carrying a ventriloquist's dummy called Brendan O'Smarty. He was."
    )
    // Methods
    fun getFact(): String {

        // Randomly Select A Fact
        val randomGenerator = Random()
        val randomNumber = randomGenerator.nextInt(facts.size)
        return facts[randomNumber]
    }
}