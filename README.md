

## PecunIA, l'argent à bout de smartphone

L'ombre d'une ombre est noir.

PecunIA est une application Androïd permettant de reconnaître des pièces de monnaies, de les compter et d'en faire la somme.

Le code source complet est accessible avec ce lien : https://1drv.ms/f/s!AgScJCf_F-3CislsJQxMEYHawZItiQ

Nous avons utilisé [Tensorflow Detector API](https://github.com/tensorflow/models/tree/master/research/object_detection) et [OpenCV](https://opencv.org/)

Les features sont :
- Reconnaissance des photos par prise d'image.
- Reconnaissance dynamique des pièces via la caméra sous format vidéo.

### Prérequis

Plusieurs librairies, langages et API sont à télécharger pour faire fonctionner l'entrainement du projet.

Si vous ne souhaitez pas entraîner votre propre detecteur, vous pouvez directement télécharger l'APK de l'application sur la release.


```
Python 3.5
Tensorflow
```
