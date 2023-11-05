/*
 * Copyright (c) 2023.
 * Author: Igor Volotovskyi
 */

package ait.album.dao;

import ait.album.model.Photo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Predicate;

public class AlbumImpl implements Album {
    private Photo[] photos;
    private int size;

    public AlbumImpl(int capacity) {
        this.photos = new Photo[capacity];
    }

    @Override
    public boolean addPhoto(Photo photo) {
        if (photo == null || getPhotoFromAlbum(photo.getPhotoId(), photo.getAlbumId()) != null
                || size == photos.length) {
            return false;
        }
        photos[size++] = photo;
//        keepPhotoSorted(photo);
        return true;
    }

    @Override
    public boolean removePhoto(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                photos[i] = getPhotoFromAlbum(photoId, albumId);
                System.arraycopy(photos, i + 1, photos, i, (size--) - i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePhoto(int photoId, int albumId, String url) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                photos[i].setUrl(url);
                return true;
            }
        }
        return false;
    }

    @Override
    public Photo getPhotoFromAlbum(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                return photos[i];
            }
        }
        return null;
    }

    @Override
    public Photo[] getAllPhotoFromAlbum(int albumId) {
        int index = 0;
        Photo[] resPhoto = new Photo[size];
        for (int i = 0; i < size; i++) {
            if (photos[i].getAlbumId() == albumId) {
                resPhoto[index++] = photos[i];
            }
        }
        return Arrays.copyOf(resPhoto, index);
    }

    @Override
    public Photo[] getPhotoBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        int index = 0;
        Photo[] resPhoto = new Photo[size];
        for (int i = 0; i < size; i++) {
            if (photos[i].getDate().toLocalDate().isEqual(dateFrom) || photos[i].getDate().toLocalDate().isEqual(dateTo)) {
                resPhoto[index++] = photos[i];
            }
        }
        return Arrays.copyOf(resPhoto, index);
    }

    @Override
    public int size() {
        return size;
    }

    private void keepPhotoSorted(Photo photo) {
        Photo[] photoCopy = Arrays.copyOf(photos, photos.length + 1);
        Arrays.sort(photoCopy);
        int index = Arrays.binarySearch(photoCopy, 0, photoCopy.length - 1, photo);
        index = index >= 0 ? index : -index - 1;
        System.arraycopy(photoCopy, index, photoCopy, index + 1, photoCopy.length - index - 1);
        photoCopy[index] = photo;
        photos = photoCopy;
    }
}
