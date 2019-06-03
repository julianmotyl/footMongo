// Coupe du monde 2014 - Julian MOTYL - Etienne DUMONTET

/*
	Pour l'import des données situées dans les fichiers Json "Equipes", "Joueurs" et "Matchs",
	nous avons utilisé la commande mongoimport dans l'invité de commandes Windows.
	
	Insertion des équipes :
	mongoimport --db Football_Players --collection Clubs --type Json --file "C:\Users\user\Documents\Equipes.Json" --jsonArray

	Insertion des joueurs :
	mongoimport --db Football_Players --collection Players --type Json --file "C:\Users\user\Documents\Joueurs.Json" --jsonArray
	
	Insertion des Matchs :
	mongoimport --db Football_Players --collection Matchs --type Json --file "C:\Users\user\Documents\Matchs.Json" --jsonArray
*/

// Note : la taille et le poids des joueurs ont été définis aléatoirement

// Requête : Equipes par nom

db.Clubs.find({
	"nom": "Espagne"
});

db.Clubs.find({
	$or: [
	{
		"nom": "Espagne"
	}, 
	{
		"nom": "France"
	}
]});

// Requête : Joueurs par nom

db.Players.find({
	"nom": "James Rodriguez"
});

// Requête : Joueurs par poids et poste (attaquants de moins de 80kg)

db.Players.find({
	$and: [
	{
		"poste":"Attaquant"
	},
	{
		"poids":{$lt: 80}
	}
]});

// Requête : insertion d'une Equipe

db.Clubs.insert({
	"nom": "Norvege",
	"groupe": "Unknown",
	"selectionneur": "Lars Lagerbäck",
	"classementFifa": "47",
	"effectif": "",
	"selection": ""
});
	
// Requête : insertion d'un Joueur

db.Players.insert({
	"nom": "Mohamed Elyounoussi",
	"taille": 1.80,
	"poids": 75,
	"date_de_naissance": "2 mars 1994",
	"poste": "Attaquant",
	"championnat": "Angleterre",
	"club": "Southampton",
	"selections": 24
});

// Requête : insertion d'un Match

db.Matchs.insert({
	"HomeTeam": "Norvege",
	"AwayTeam": "Italie",
	"HomeScore": 3,
	"AwayScore": 1,
	"BestHomePlayer": {
		"Name": "Mohamed Elyounoussi",
		"Note": 9
	},
	"BestAwayPlayer": {
		"Name": "Andrea Pirlo",
		"Note": 5
	}
});

// Requête : Joueurs ayant joué plus de x matchs avec la moyenne des notes

/*db.Matchs.ensureIndex({
	"BestHomePlayer.Name":1,
	"BestAwayPlayer.Name":1
});
db.Players.find({
	"nom": {$eq: db.Matchs.BestHomePlayer.Name}
});*/