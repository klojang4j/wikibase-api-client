package org.klojang.wbapiclient.model;

/**
 * A language-bound string &#8212; that is, a string that is associated with a language
 * code. The language code is deliberately kept as a string and not as a symbolic constant
 * or an {@code enum}. Using a symbolic constant or {@code enum} to represent a language
 * would make the Wikibase API client too dependent on changes in the set of languages
 * currently defined in Wikidata. (Note that languages are themselves Wikidata items.)
 * Each change would require a new release of the Wikibase API client. Also note that
 * Wikidata language codes by and large are the same as ISO language codes, but <i>not
 * necessarily</i>. <p>See <a
 * href="https://www.wikidata.org/wiki/Help:Wikimedia_language_codes/lists/all">this
 * Wikidata page</a> for a list of valid language codes.
 *
 * @param language the two-, three- or six-letter language code
 * @param value the string
 */
public record MLString(String language, String value) { }
