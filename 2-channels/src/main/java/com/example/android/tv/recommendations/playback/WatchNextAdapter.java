/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.example.android.tv.recommendations.playback;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.media.tv.WatchNextProgram;
import android.util.Log;

import com.example.android.tv.recommendations.model.MockDatabase;
import com.example.android.tv.recommendations.model.Movie;

/** Adds, updates, and removes the currently playing {@link Movie} from the "Watch Next" channel. */
public class WatchNextAdapter {

    private static final String TAG = "WatchNextAdapter";

    public void updateProgress(
            Context context, long channelId, Movie movie, long position, long duration) {
        Log.d(TAG, String.format("Updating the movie (%d) in watch next.", movie.getId()));

        Movie entity = MockDatabase.findMovieById(context, channelId, movie.getId());
        if (entity == null) {
            Log.e(
                    TAG,
                    String.format(
                            "Could not find movie in channel: channel id: %d, movie id: %d",
                            channelId, movie.getId()));
            return;
        }

        // TODO: step 12 add watch next program.

    }

    @NonNull
    private WatchNextProgram createWatchNextProgram(
            long channelId, Movie movie, long position, long duration) {
        // TODO: step 13 convert movie
        return null;
    }

    public void removeFromWatchNext(Context context, long channelId, long movieId) {
        Movie movie = MockDatabase.findMovieById(context, channelId, movieId);
        if (movie == null || movie.getWatchNextId() < 1L) {
            Log.d(TAG, "No program to remove from watch next.");
            return;
        }

        // TODO: step 15 remove program

        // Sync our records with the system; remove reference to watch next program.
        movie.setWatchNextId(-1);
        MockDatabase.saveMovie(context, channelId, movie);
    }
}
