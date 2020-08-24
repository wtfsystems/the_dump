/*
 * Diamond Square Example
 * By:  Matthew Evans
 * File:  main.cpp
 *
 * See LICENSE.md for copyright information
 *
 * Creates a height map then generates a grayscale image.
 * Benchmarks the height map creation and image creation.
 *
 */

#include <allegro5/allegro.h>

#include "include/diamond_square.hpp"
#include "include/benchmark.hpp"

int main(int argc, char **argv) {
    if(!al_init()) return -1; //  Allegro didn't load - Exit

    ALLEGRO_DISPLAY* display = al_create_display(960, 960);
    ALLEGRO_EVENT_QUEUE* event_queue = al_create_event_queue();

    al_register_event_source(event_queue, al_get_display_event_source(display));

    //  Create the map
    diamond_square my_map = diamond_square(10, 0.096f);
    //diamond_square my_map = diamond_square(3, 0.00009f, 100);

    benchmark build_map_bhmk = benchmark<std::chrono::microseconds>("Map Building");
    my_map.build_map();
    build_map_bhmk.stop();

    benchmark draw_map_bhmk = benchmark<std::chrono::milliseconds>("Map Drawing");
    ALLEGRO_BITMAP* map_bmp = al_create_bitmap(my_map.get_side(), my_map.get_side());

    //  Draw the map
    al_set_target_bitmap(map_bmp);
    al_clear_to_color(al_map_rgb(0, 0, 0));
    for(int x = 0; x < my_map.get_side(); x++) {
        for(int y = 0; y < my_map.get_side(); y++) {
            const double pos = my_map.get_value((y * my_map.get_side()) + x);
            al_put_pixel(x, y, al_map_rgb(255 * pos, 255 * pos, 255 * pos));
        }
    }
    draw_map_bhmk.stop();

    bool loop = true;
    while(loop) {
        al_set_target_backbuffer(al_get_current_display());
        al_clear_to_color(al_map_rgb(0, 0, 0));
        al_draw_scaled_bitmap(map_bmp, 0, 0, al_get_bitmap_width(map_bmp), al_get_bitmap_height(map_bmp), 0, 0, 960, 960, 0);
        al_flip_display();

        ALLEGRO_EVENT event;
        al_get_next_event(event_queue, &event);
        if(event.type == ALLEGRO_EVENT_DISPLAY_CLOSE) loop = false;
    }

    al_destroy_bitmap(map_bmp);
    al_destroy_event_queue(event_queue);
    al_destroy_display(display);

    al_uninstall_system();

    return 0;
}
