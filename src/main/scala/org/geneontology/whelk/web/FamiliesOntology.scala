package org.geneontology.whelk.web

object FamiliesOntology {

  val text =
    """Prefix(:=<http://example.com/owl/families/>)
Prefix(otherOnt:=<http://example.org/otherOntologies/families/>)
Prefix(xsd:=<http://www.w3.org/2001/XMLSchema#>)
Prefix(owl:=<http://www.w3.org/2002/07/owl#>)
Prefix(rdfs:=<http://www.w3.org/2000/01/rdf-schema#>)
Prefix(dc:=<http://purl.org/dc/terms/>)
Ontology(<http://example.com/owl/families>
Annotation( dc:source <https://www.w3.org/TR/owl2-primer/> )

Declaration( NamedIndividual( :John ) )
Declaration( NamedIndividual( :Mary ) )
Declaration( NamedIndividual( :Jim ) )
Declaration( NamedIndividual( :James ) )
Declaration( NamedIndividual( :Jack ) )
Declaration( NamedIndividual( :Bill ) )
Declaration( NamedIndividual( :Susan ) )
Declaration( Class( :Person ) )
AnnotationAssertion( rdfs:comment :Person "Represents the set of all people." )
Declaration( Class( :Woman ) )
Declaration( Class( :Parent ) )
Declaration( Class( :Father ) )
Declaration( Class( :Mother ) )
Declaration( Class( :SocialRole ) )
Declaration( Class( :Man ) )
Declaration( Class( :Teenager ) )
Declaration( Class( :ChildlessPerson ) )
Declaration( Class( :Human ) )
Declaration( Class( :Female ) )
Declaration( Class( :HappyPerson ) )
Declaration( Class( :JohnsChildren ) )
Declaration( Class( :NarcisticPerson ) )
Declaration( Class( :MyBirthdayGuests ) )
Declaration( Class( :Dead ) )
Declaration( Class( :Orphan ) )
Declaration( Class( :Adult ) )
Declaration( Class( :YoungChild ) )
Declaration( ObjectProperty( :hasWife ) )
Declaration( ObjectProperty( :hasChild ) )
Declaration( ObjectProperty( :hasDaughter ) )
Declaration( ObjectProperty( :loves ) )
Declaration( ObjectProperty( :hasSpouse ) )
Declaration( ObjectProperty( :hasGrandparent ) )
Declaration( ObjectProperty( :hasParent ) )
Declaration( ObjectProperty( :hasBrother ) )
Declaration( ObjectProperty( :hasUncle ) )
Declaration( ObjectProperty( :hasSon ) )
Declaration( ObjectProperty( :hasAncestor ) )
Declaration( ObjectProperty( :hasHusband ) )
Declaration( DataProperty( :hasAge ) )
Declaration( DataProperty( :hasSSN ) )
Declaration( Datatype( :personAge ) )
Declaration( Datatype( :minorAge ) )
Declaration( Datatype( :majorAge ) )
Declaration( Datatype( :toddlerAge ) )

SubObjectPropertyOf( :hasWife :hasSpouse )
SubObjectPropertyOf(
  ObjectPropertyChain( :hasParent :hasParent )
  :hasGrandparent
)
SubObjectPropertyOf(
  ObjectPropertyChain( :hasFather :hasBrother )
  :hasUncle
)
SubObjectPropertyOf(
  :hasFather
  :hasParent
)

EquivalentObjectProperties( :hasChild otherOnt:child )
InverseObjectProperties( :hasParent :hasChild )
EquivalentDataProperties( :hasAge otherOnt:age )
DisjointObjectProperties( :hasSon :hasDaughter )
ObjectPropertyDomain( :hasWife :Man )
ObjectPropertyRange( :hasWife :Woman )
DataPropertyDomain( :hasAge :Person )
DataPropertyRange( :hasAge xsd:nonNegativeInteger )

SymmetricObjectProperty( :hasSpouse )
AsymmetricObjectProperty( :hasChild )
DisjointObjectProperties( :hasParent :hasSpouse )
ReflexiveObjectProperty( :hasRelative )
IrreflexiveObjectProperty( :parentOf )
FunctionalObjectProperty( :hasHusband )
InverseFunctionalObjectProperty( :hasHusband )
TransitiveObjectProperty( :hasAncestor )
FunctionalDataProperty( :hasAge )

SubClassOf( :Woman :Person )
SubClassOf( :Mother :Woman )
SubClassOf(
  :Grandfather
  ObjectIntersectionOf( :Man :Parent )
)
SubClassOf(
  :Teenager
  DataSomeValuesFrom( :hasAge
    DatatypeRestriction( xsd:integer
      xsd:minExclusive "12"^^xsd:integer
      xsd:maxInclusive "19"^^xsd:integer
    )
  )
)
SubClassOf(
  Annotation( rdfs:comment "States that every man is a person." )
  :Man
  :Person
)
SubClassOf(
  :Father
  ObjectIntersectionOf( :Man :Parent )
)
SubClassOf(
  :ChildlessPerson
  ObjectIntersectionOf(
    :Person
    ObjectComplementOf(
      ObjectSomeValuesFrom(
        ObjectInverseOf( :hasParent )
        owl:Thing
      )
    )
  )
)
SubClassOf(
  ObjectIntersectionOf(
    ObjectOneOf( :Mary :Bill :Meg )
    :Female
  )
  ObjectIntersectionOf(
    :Parent
    ObjectMaxCardinality( 1 :hasChild )
    ObjectAllValuesFrom( :hasChild :Female )
  )
)

EquivalentClasses( :Person :Human )
EquivalentClasses(
  :Mother
  ObjectIntersectionOf( :Woman :Parent )
)
EquivalentClasses(
  :Parent
  ObjectUnionOf( :Mother :Father )
)
EquivalentClasses(
  :ChildlessPerson
  ObjectIntersectionOf(
    :Person
    ObjectComplementOf( :Parent )
  )
)
EquivalentClasses(
  :Parent
  ObjectSomeValuesFrom( :hasChild :Person )
)
EquivalentClasses(
  :HappyPerson
  ObjectIntersectionOf(
     ObjectAllValuesFrom( :hasChild :HappyPerson )
     ObjectSomeValuesFrom( :hasChild :HappyPerson )
  )
)
EquivalentClasses(
  :JohnsChildren
  ObjectHasValue( :hasParent :John )
)
EquivalentClasses(
  :NarcisticPerson
  ObjectHasSelf( :loves )
)
EquivalentClasses(
  :MyBirthdayGuests
  ObjectOneOf( :Bill :John :Mary)
)
EquivalentClasses(
  :Orphan
  ObjectAllValuesFrom(
    ObjectInverseOf( :hasChild )
    :Dead
  )
)
EquivalentClasses( :Adult otherOnt:Grownup )
EquivalentClasses(
  :Parent
  ObjectSomeValuesFrom(
    :hasChild
    :Person
  )
)

DisjointClasses( :Woman :Man )
DisjointClasses(
  :Mother
  :Father
  :YoungChild
)
HasKey( :Person () ( :hasSSN ) )

DatatypeDefinition(
  :personAge
  DatatypeRestriction( xsd:integer
    xsd:minInclusive "0"^^xsd:integer
    xsd:maxInclusive "150"^^xsd:integer
  )
)
DatatypeDefinition(
  :minorAge
  DatatypeRestriction( xsd:integer
    xsd:minInclusive "0"^^xsd:integer
    xsd:maxInclusive "18"^^xsd:integer
  )
)
DatatypeDefinition(
  :majorAge
  DataIntersectionOf(
    :personAge
    DataComplementOf( :minorAge )
  )
)
DatatypeDefinition(
  :toddlerAge
  DataOneOf( "1"^^xsd:integer "2"^^xsd:integer )
)

ClassAssertion( :Person :Mary )
ClassAssertion( :Woman :Mary )
ClassAssertion(
  ObjectIntersectionOf(
    :Person
    ObjectComplementOf( :Parent )
  )
  :Jack
)
ClassAssertion(
  ObjectMaxCardinality( 4 :hasChild :Parent )
  :John
)
ClassAssertion(
  ObjectMinCardinality( 2 :hasChild :Parent )
  :John
)
ClassAssertion(
  ObjectExactCardinality( 3 :hasChild :Parent )
  :John
)
ClassAssertion(
  ObjectExactCardinality( 5 :hasChild )
  :John
)
ClassAssertion( :Father :John )
ClassAssertion( :SocialRole :Father )

ObjectPropertyAssertion( :hasWife :John :Mary )
NegativeObjectPropertyAssertion( :hasWife :Bill :Mary )
NegativeObjectPropertyAssertion(
  :hasDaughter
  :Bill
  :Susan
)
DataPropertyAssertion( :hasAge :John "51"^^xsd:integer )
NegativeDataPropertyAssertion( :hasAge :Jack "53"^^xsd:integer )

SameIndividual( :James :Jim )
SameIndividual( :John otherOnt:JohnBrown )
SameIndividual( :Mary otherOnt:MaryBrown )
DifferentIndividuals( :John :Bill )
)
"""

}
