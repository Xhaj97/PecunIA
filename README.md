

# PecunIA, l'argent à bout de smartphone


*Dernière update le 24/05/2018.*

## Avant-propos

L'ombre d'une ombre est noir.

PecunIA est une application Androïd permettant de reconnaître des pièces de monnaies, de les compter et d'en faire la somme.

Le code source complet est accessible avec ce lien : https://1drv.ms/f/s!AgScJCf_F-3CislsJQxMEYHawZItiQ.
**Nous n'avons pas mis le code sur Git car on a énormément de données sur et son usage a donc été limité par cela**

Nous avons utilisé [Tensorflow Detector API](https://github.com/tensorflow/models/tree/master/research/object_detection) et [OpenCV](https://opencv.org/)

Les features sont :
- Reconnaissance des photos par prise d'image.
- Reconnaissance dynamique des pièces via la caméra sous format vidéo.

### Introduction

L'objectif de ce projet est d'aider les paresseux mais aussi les malvoyants et toutes les personnes qui n'aiment pas compter leur argent de le faire à portée de main à l'aide d'une application Androïd. A la fois, simple efficace et ergonomique, le projet s'adapte facilement à toutes les situations et les possibilités. Après avoir suivi ces exemples, voici ce que vous arriverez à faire :

![Example](https://scontent-cdg2-1.xx.fbcdn.net/v/t1.15752-9/32260472_1660789980643505_5876938600204992512_n.png?_nc_cat=0&oh=59c1aedb955c220c35fa995dc3314650&oe=5B7E6F81)
![Example2](https://scontent-cdg2-1.xx.fbcdn.net/v/t34.18173-12/30422210_2015240285355430_1735805130_n.png?_nc_cat=0&oh=8bdb0a34c2313788d251db661d95e9b7&oe=5B091F96)
### Prérequis

Plusieurs librairies, langages et API sont à télécharger pour faire fonctionner l'entrainement du projet.

Si vous ne souhaitez pas entraîner votre propre detecteur, vous pouvez directement télécharger l'APK de l'application sur la release.


```
Python 3.5
Tensorflow
Anaconda
AndroidStudio
Java
OpenCV
```

Pour ce tutoriel, vous avez besoin de cloner le repository de [Tensorflow1.8](https://github.com/tensorflow/tensorflow/tree/r1.8) et d'installer [AndroidStudio](https://developer.android.com/studio/) puis Anaconda que nous allons voir tout de suite.

#### Téléchargement est mise en place de l'environnement Anaconda
Pour installer l'environnement, veuillez télécharger [Anaconda](https://www.anaconda.com/download/) nous utilisons la version 3.6 mais rien n'empêche de prendre une version plus élevée ou inférieure car lors du lancement du script, on va créer un environnement 3.5 compatible avec tout le monde, un gestionnaire d'environnement portable et versatile

Après avoir téléchargé Anaconda, veuillez ouvrir la commande prompt et copier coller les lignes suivantes :

```
# pour installer l'environnement: (copy paste)
# installer anaconda
# lancer anaconda prompt
# copier coller toutes les lignes suivantes

conda create -n tensorflow1 pip python=3.5
y
activate tensorflow1
pip install --ignore-installed --upgrade tensorflow-gpu
conda install -c anaconda protobuf
y
pip install pillow
pip install lxml
pip install Cython
pip install jupyter
pip install matplotlib
pip install pandas
pip install opencv-python



#pour activer l'environnement virtuel créé avec anaconda
conda activate tensorflow1

# pour changer de dossier (ici le projet est présent dans C:\tensorflow1\models\research\object_detection)
cd C:\tensorflow1\models\research\object_detection

#pour mettre une variable d'environnement nécessaire
set PYTHONPATH=C:\tensorflow1\models;C:\tensorflow1\models\research;C:\tensorflow1\models\research\slim


#pour avoir accès au tensorboard (après avoir exécuté la commande suivante, il faut ouvrir un navigateur et taper localhost:6006)
tensorboard --logdir==training:C:\tensorflow1\models\research\object_detection\training --host=127.0.0.1


# pour entrainer le model en fonction de la config utilisée 

#config faster rcnn inception v2
python train.py --logtostderr --train_dir=training/ --pipeline_config_path=training/faster_rcnn_inception_v2_pets.config

#config ssd_mobilenet_v1_coco
python train.py --logtostderr --train_dir=training/ --pipeline_config_path=training/ssd_mobilenet_v1_coco.config


# pour exporter le graphe d'inférence (le graphe final qui ne sera plus entrainé, et qui permet la detection)
# en fonction de la config:

#config faster rcnn inception v2
python export_inference_graph.py --input_type image_tensor --pipeline_config_path training/faster_rcnn_inception_v2_pets.config --trained_checkpoint_prefix training/model.ckpt-XXXX --output_directory inference_graph

#config ssd_mobilenet_v1_coco
python export_inference_graph.py --input_type image_tensor --pipeline_config_path training/ssd_mobilenet_v1_coco.config --trained_checkpoint_prefix training/model.ckpt-XXXX --output_directory inference_graph

```

Cela va générer automatiquement un environnement de développement pour notre système.
Pour tout autre problème, vous pouvez suivre ce tutoriel :

[Example pour l'entrainement d'un modèle avec tensorflow](https://github.com/EdjeElectronics/TensorFlow-Object-Detection-API-Tutorial-Train-Multiple-Objects-Windows-10)

[Code permettant l'entrainement avec tensorflow](https://1drv.ms/u/s!AgScJCf_F-3CitYsUC4BeDeZPvph3Q)
(le code se trouve dans tensorflow1/models/research/object_detection)

Ensuite, suivre les instructions de cette vidéo :

[![Watch the video](https://raw.githubusercontent.com/EdjeElectronics/TensorFlow-Object-Detection-API-Tutorial-Train-Multiple-Objects-Windows-10/master/doc/YouTube%20video.jpg)](https://www.youtube.com/watch?v=Rgpfk6eYxJA)
